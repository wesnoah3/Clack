package main;

import data.ClackData;
import java.util.Objects;
import data.MessageClackData;

/**
 * Class to store and maintain all relevant ClackServer data.
 */
public class ClackServer {

    private static final int DEFAULT_PORT = 7000;
    private int port;
    private boolean closeConnection;
    private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;
    /**
     * Ctor accepting port.
     * @param port User's port.
     */
    public ClackServer(int port) {
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
        return Objects.hash(this.port, this.closeConnection, this.dataToReceiveFromClient, this.dataToSendToClient);
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
