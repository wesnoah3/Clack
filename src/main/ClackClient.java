package main;

import data.ClackData;
import data.MessageClackData;

/**
 * Class to store and maintain all relevant ClackClient data.
 */
public class ClackClient {
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
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
    }
    /**
     * Ctor accepting userName and hostName.
     * @param userName User's userName.
     * @param hostName User's hostName.
     */
    public ClackClient(String userName, String hostName) {
        this.userName = userName;
        this.hostName = hostName;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
    }
    /**
     * Ctor accepting userName.
     * @param userName User's userName.
     */
    public ClackClient(String userName) {
        this.userName = userName;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
    }
    /**
     * Default ctor.
     */
    public ClackClient() {
        super();
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
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
        return this.userName.hashCode() + this.hostName.hashCode() + this.port;
    }
    /**
     * Takes object, returns true if its equal to this.
     * @param o Passed object to compare to.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ClackClient) {
            ClackClient input = (ClackClient) o;
            if (this.userName == input.userName && this.hostName == input.hostName && this.port == input.port) {
                return true;
            }
        }
        return false;
    }
    /**
     * Generates toStringed message including all object data
     * @return toString String.
     */
    @Override
    public String toString() {
        String s = "Username: " + this.userName + " HostName: " + this.hostName + " Port: " + this.port;
        return s;
    }
}
