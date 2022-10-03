package main;

import data.ClackData;
import data.MessageClackData;

public class ClackServer {

    final int defaultPort = 7000;
    int port;
    boolean closeConnection;
    ClackData dataToReceiveFromClient;
    ClackData dataToSendToClient;
    /*
     * Ctor accepting port
     * @param port
     */
    public ClackServer(int port) {
        this.port = port;
    }
    /*
     * Default ctor
     */
    public ClackServer() {
        this.port = defaultPort;
    }
    /*
     * Method to start ClackServer
     */
    public void start() {

    }
    /*
     * Method to receive data
     */
    public void receiveData() {

    }
    /*
     * Method to send data
     */
    public void sendData() {

    }
    /*
     * Method to return port
     */
    public int getPort() {
        return this.port;
    }
    /*
     * Returns unique hashcode of object
     */
    @Override
    public int hashCode() {
        if (closeConnection) {
            return this.port + 1;
        }
        return this.port;
    }
    /*
     * Takes object, returns true if its equal to this
     * @param ClackServer object
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ClackServer) {
            ClackServer input = (ClackServer) o;
            if (this.port == input.port) {
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
        String s = "Port: " + this.port + " ConnectionClosed: " + this.closeConnection;
        return s;
    }
}
