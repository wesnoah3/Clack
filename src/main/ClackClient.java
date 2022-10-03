package main;

import data.ClackData;
import data.MessageClackData;

public class ClackClient {
    String userName;
    String hostName;
    int port;
    boolean closeConnection;
    ClackData dataToSendToServer;
    ClackData dataToReceiveFromServer;
    /*
     * Ctor accepting userName, hostName, and port
     * @param userName
     * @param hostName
     * @param port
     */
    public ClackClient(String userName, String hostName, int port) {
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
    }
    /*
     * Ctor accepting userName and hostName
     * @param userName
     * @param hostName
     */
    public ClackClient(String userName, String hostName) {
        this.userName = userName;
        this.hostName = hostName;
    }
    /*
     * Ctor accepting userName
     * @param userName
     */
    public ClackClient(String userName) {
        this.userName = userName;
    }
    /*
     * Default ctor
     */
    public ClackClient() {
        //Should call another ctor.. but what ctor
    }
    /*
     * Method to start ClackClient
     */
    public void start() {

    }
    /*
     * Method to read client data
     */
    public void readClientData() {

    }
    /*
     * Method to send data
     */
    public void sendData() {

    }
    /*
     * Method to receive data
     */
    public void receiveData() {

    }
    /*
     * Method to print data
     */
    public void printData() {

    }
    /*
     * Returns username
     */
    public String getUserName() {
        return this.userName;
    }
    /*
     * Returns hostname
     */
    public String getHostName() {
        return this.hostName;
    }
    /*
     * Returns port
     */
    public int getPort() {
        return this.port;
    }
    /*
     * Returns unique hashcode of object
     */
    @Override
    public int hashCode() {
        return this.userName.hashCode() + this.hostName.hashCode() + this.port;
    }
    /*
     * Takes object, returns true if its equal to this
     * @param ClackClient object
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
    /*
     * Returns toStringed message including all object data
     */
    @Override
    public String toString() {
        String s = "Username: " + this.userName + " HostName: " + this.hostName + " Port: " + this.port;
        return s;
    }
}
