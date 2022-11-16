package main;

import data.ClackData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.Scanner;

import data.FileClackData;
import data.MessageClackData;

/**
 * Class to store and maintain all relevant ClackClient data.
 */
public class ClackClient {
    /**
     * Default port
     */
    private static final int DEFAULT_PORT = 7000;
    /**
     * String to represent name of the client.
     */
    private String userName;
    /**
     * String to represent name of computer representing the server.
     */
    private String hostName;
    /**
     * Integer representing port number.
     */
    private int port;
    /**
     * Boolean representing whether connection is closed or not.
     */
    private boolean closeConnection;
    /**
     * ClackData object representing the data sent to the server.
     */
    private ClackData dataToSendToServer;
    /**
     * ClackData object representing the data received from the server.
     */
    private ClackData dataToReceiveFromServer;
    /**
     * Scanner object to get input from user.
     */
    private Scanner inFromStd;
    /**
     * Input stream to receive data packets from the server.
     */
    private ObjectInputStream inFromServer = null;
    /**
     * Output stream to send data packets to the server.
     */
    private ObjectOutputStream outToServer = null;
    /**
     * Ctor accepting userName, hostName, and port.
     * @param userName User's userName.
     * @param hostName User's hostName.
     * @param port User's port.
     * @throws IllegalArgumentException
     */
    public ClackClient(String userName, String hostName, int port) throws IllegalArgumentException {
        if (userName == null) {
            throw new IllegalArgumentException("Username must not be null");
        } else {
            this.userName = userName;
        }
        if (hostName == null) {
            throw new IllegalArgumentException("Hostname must not be null");
        } else {
            this.hostName = hostName;
        }
        if (port < 1024) {
            throw new IllegalArgumentException("Port must be at least 1024");
        }
        else {
            this.port = port;
        }
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
    }
    /**
     * Ctor accepting userName and hostName.
     * @param userName User's userName.
     * @param hostName User's hostName.
     */
    public ClackClient(String userName, String hostName) {
        this(userName, hostName, DEFAULT_PORT);
    }
    /**
     * Ctor accepting userName.
     * @param userName User's userName.
     */
    public ClackClient(String userName) {
        this(userName, "localhost");
    }
    /**
     * Default ctor.
     */
    public ClackClient() {
        this("Anon");
    }
    /**
     * Method to start ClackClient and print data if connection hasn't closed.
     */
    public void start() {
        try {
            Socket socket = new Socket(hostName, port);
            inFromServer = new ObjectInputStream(socket.getInputStream());
            outToServer = new ObjectOutputStream(socket.getOutputStream());
            this.inFromStd = new Scanner(System.in);
            while (!this.closeConnection) {
                readClientData();
                this.dataToReceiveFromServer = this.dataToSendToServer;
                printData();
                this.readClientData();
                this.sendData();
            }
            inFromStd.close();
            socket.close();
        } catch (IOException ioe) {
            System.err.println(("IOException occurred"));
        }
    }
    /**
     * Reads client data via System.in and operates accordingly.
     */
    public void readClientData() {
        String str = inFromStd.nextLine();
        if (str == "DONE") {
            this.closeConnection = true;
        }
        else if (str.contains("SENDFILE")) {
            str.substring(str.indexOf("SENDFILE") + 3, str.length());
            this.dataToSendToServer = new FileClackData(this.userName, str, ClackData.CONSTANT_SENDFILE);
            try {
                ((FileClackData) this.dataToSendToServer).readFileContents();
            } catch (IOException e) {
                System.err.println("Error occurred reading file contents with SENDFILE");
                e.printStackTrace();
            }
        }
        else if (str == "LISTUSERS") {

        }
        else {
            this.dataToSendToServer = new MessageClackData(this.userName, "", ClackData.CONSTANT_SENDMESSAGE);
        }
    }
    /**
     * Method to send data to server.
     */
    public void sendData() {
        try {
            outToServer.writeObject(dataToSendToServer);
        } catch (NoRouteToHostException nrthe) {
            System.err.println("No route to host exception occurred");
        } catch (UnknownHostException uhe) {
            System.err.println("Unknown host exception occurred");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        }
    }
    /**
     * Method to receive data from server.
     */
    public void receiveData() {
        try {
            dataToReceiveFromServer = (ClackData) inFromServer.readObject();
        } catch (NoRouteToHostException nrthe) {
            System.err.println("No route to host exception occurred");
        } catch (UnknownHostException uhe) {
            System.err.println("Unknown host exception occurred");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Class not found exception occurred");
        }
    }
    /**
     * Method to print data.
     */
    public void printData() {
        System.out.println(this.dataToReceiveFromServer.getData().toString());
    }
    /**
     * Gets userName.
     * @return userName.
     */
    public String getUserName() {
        return this.userName;
    }
    /**
     * Gets hostName.
     * @return hostName.
     */
    public String getHostName() {
        return this.hostName;
    }
    /**
     * Gets port.
     * @return port integer.
     */
    public int getPort() {
        return this.port;
    }
    /**
     * Generates unique hashcode of object
     * @return hashCode integer.
     */

    public static void main(String args[]) {
        try {
            ClackClient client;
            if (args.length > 0) { //Catches all non-default construtors
                final String passed = args[0];
                if (passed.contains("@")) { //Catches all constructors with hostname
                    if (passed.contains(":")) { //Catch all constructors with portnumber
                        final String user = passed.split("@")[0];
                        final String host = passed.split("@")[1].split(":")[0];
                        final int port = Integer.parseInt(passed.split(":")[1]);
                        client = new ClackClient(user, host, port);
                    } else {
                        final String user = passed.split("@")[0];
                        final String host = passed.split("@")[1];
                        client = new ClackClient(user, host);
                    }
                } else {
                    client = new ClackClient(passed);
                }
            } else {
                client = new ClackClient();
            }
            client.start();
        } catch (NumberFormatException nfe) {
            System.err.println("Number format exception occurred");
        }
    }

    /**
     * Method to get unique hashcode for each object.
     * @return Unique hashcode
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 31 * result + Objects.hashCode(this.userName);
        result = 31 * result + Objects.hashCode(this.hostName);
        result = 31 * result + this.port;
        result = 31 * result + Objects.hashCode(this.closeConnection);
        result = 31 * result + Objects.hashCode(this.dataToSendToServer);
        result = 31 * result + Objects.hashCode(this.dataToReceiveFromServer);

        return result;
    }
    /**
     * Takes object, returns true if its equal to this.
     * @param o Passed object to compare to.
     * @return Whether the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClackClient)) {
            return false;
        }

        ClackClient otherClackClient = (ClackClient) o;

        return this.userName.equals(otherClackClient.userName) &&
                this.hostName.equals(otherClackClient.hostName) &&
                this.port == otherClackClient.port &&
                this.closeConnection == otherClackClient.closeConnection &&
                Objects.equals(this.dataToSendToServer, otherClackClient.dataToSendToServer) &&
                Objects.equals(this.dataToReceiveFromServer, otherClackClient.dataToReceiveFromServer);
    }
    /**
     * Generates toStringed message including all object data
     * @return toString String.
     */
    @Override
    public String toString() {
        return "This instance of ClackClient has the following properties:\n"
                + "Username: " + this.userName + "\n"
                + "Host name: " + this.hostName + "\n"
                + "Port number: " + this.port + "\n"
                + "Connection status: " + (this.closeConnection ? "Closed" : "Open") + "\n"
                + "Data to send to the server: " + this.dataToSendToServer + "\n"
                + "Data to receive from the server: " + this.dataToReceiveFromServer + "\n";
    }
}
