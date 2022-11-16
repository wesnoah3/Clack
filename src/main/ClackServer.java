package main;

import data.ClackData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import data.MessageClackData;

/**
 * Class to store and maintain all relevant ClackServer data.
 */
public class ClackServer {
    /**
     * Default port
     */
    private static final int DEFAULT_PORT = 7000;
    /**
     * Integer representing port number.
     */
    private int port;
    /**
     * Boolean representing whether connection is closed or not.
     */
    private boolean closeConnection;
    /**
     * ClackData object representing the data received from the server.
     */
    private ClackData dataToReceiveFromClient;
    /**
     * ClackData object representing the data sent to the client.
     */
    private ClackData dataToSendToClient;
    /**
     * Input stream to receive data packets from the client.
     */
    private ObjectInputStream inFromClient = null;
    /**
     * Output stream to send data packets to the client.
     */
    private ObjectOutputStream outToClient = null;
    /**
     * Ctor accepting port.
     * @param port User's port.
     */
    public ClackServer(int port) {
        if (port < 1024) {
            throw new IllegalArgumentException("Port must be greater than 1024");
        }
        this.port = port;
        this.closeConnection = false;
        this.dataToReceiveFromClient = null;
        this.dataToSendToClient = null;
    }
    /**
     * Default ctor.
     */
    public ClackServer() {
        this(DEFAULT_PORT);
    }
    /**
     * Method to start ClackServer, WIP
     */
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            while (!closeConnection) {
                inFromClient = new ObjectInputStream(clientSocket.getInputStream());
                outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
                this.sendData();
                this.receiveData();
            }
            serverSocket.close();
            clientSocket.close();
        } catch (NoRouteToHostException nrthe) {
            System.err.println("No route to host exception occurred");
        } catch (UnknownHostException uhe) {
            System.err.println("Unknown host exception occurred");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        }
    }
    /**
     * Method to receive data from client.
     */
    public void receiveData() {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
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
     * Method to send data to client.
     */
    public void sendData() {
        try {
            outToClient.writeObject(dataToSendToClient);
        } catch (NoRouteToHostException nrthe) {
            System.err.println("No route to host exception occurred");
        } catch (UnknownHostException uhe) {
            System.err.println("Unknown host exception occurred");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        }
    }
    /**
     * Gets port.
     * @return port integer.
     */
    public int getPort() {
        return this.port;
    }
    /**
     * Generates unique hashcode of object.
     * @return hashCode integer.
     */

    public static void main(String args[]) {
        try {
            ClackServer server;
            if (args.length > 0) {
                final String passed = args[0];
                final int port = Integer.parseInt(passed);
                server = new ClackServer(port);
            } else {
                server = new ClackServer();
            }
            server.start();
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
        return Objects.hash(this.port, this.closeConnection, this.dataToReceiveFromClient, this.dataToSendToClient);
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
        if (!(o instanceof ClackServer)) {
            return false;
        }

        ClackServer otherClackServer = (ClackServer) o;

        return this.port == otherClackServer.port
                && this.closeConnection == otherClackServer.closeConnection
                && Objects.equals(this.dataToReceiveFromClient, otherClackServer.dataToReceiveFromClient)
                && Objects.equals(this.dataToSendToClient, otherClackServer.dataToSendToClient);
    }
    /**
     * Genereates toStringed message including all object data.
     * @return toString String.
     */
    @Override
    public String toString() {
        return "This instance of ClackServer has the following properties:\n"
                + "Port number: " + this.port + "\n"
                + "Connection status: " + (this.closeConnection ? "Closed" : "Open") + "\n"
                + "Data to receive from the client: " + this.dataToReceiveFromClient + "\n"
                + "Data to send to the client: " + this.dataToSendToClient + "\n";
    }
}
