package main;

import data.ClackData;
import data.MessageClackData;

/**
 * Class to store and maintain all relevant ClackServer data.
 */
public class ClackServer {

    final int defaultPort = 7000;
    int port;
    boolean closeConnection;
    ClackData dataToReceiveFromClient;
    ClackData dataToSendToClient;
    /**
     * Ctor accepting port.
     * @param port User's port.
     */
    public ClackServer(int port) {
        this.port = port;
        this.dataToReceiveFromClient = null;
        this.dataToSendToClient = null;
    }
    /**
     * Default ctor.
     */
    public ClackServer() {
        this.port = defaultPort;
    }
    /**
     * Method to start ClackServer, WIP
     */
    public void start() {

    }
    /**
     * Method to receive data, WIP
     */
    public void receiveData() {

    }
    /**
     * Method to send data, WIP
     */
    public void sendData() {

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
    @Override
    public int hashCode() {
        if (closeConnection) {
            return this.port + 1;
        }
        return this.port;
    }
    /**
     * Takes object, returns true if its equal to this.
     * @param o Passed object to compare to.
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
    /**
     * Genereates toStringed message including all object data.
     * @return toString String.
     */
    @Override
    public String toString() {
        String s = "Port: " + this.port + " ConnectionClosed: " + this.closeConnection;
        return s;
    }
}
