package main;

import data.ClackData;
import java.util.Objects;
import data.MessageClackData;

/**
 * Class to store and maintain all relevant ClackClient data.
 */
public class ClackClient {
    private static final int DEFAULT_PORT = 7000;
    String userName;
    String hostName;
    int port;
    boolean closeConnection;
    ClackData dataToSendToServer;
    ClackData dataToReceiveFromServer;
    /**
     * Ctor accepting userName, hostName, and port.
     * @param userName User's userName.
     * @param hostName User's hostName.
     * @param port User's port.
     */
    public ClackClient(String userName, String hostName, int port) {
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
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
     * Method to start ClackClient, WIP
     */
    public void start() {

    }
    /**
     * Method to read client data, WIP
     */
    public void readClientData() {

    }
    /**
     * Method to send data, WIP
     */
    public void sendData() {

    }
    /**
     * Method to receive data, WIP
     */
    public void receiveData() {

    }
    /**
     * Method to print data, WIP
     */
    public void printData() {

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
