package main;

import data.ClackData;
import data.MessageClackData;

public class ClackServer {

    final int defaultPort = 7000;
    int port;
    boolean closeConnection;
    ClackData dataToReceiveFromClient;
    ClackData dataToSendToClient;

    public ClackServer(int port) {
        this.port = port;
    }
    public ClackServer() {
        this.port = defaultPort;
    }

    public void start() {

    }
    public void receiveData() {

    }
    public void sendData() {

    }
    public int getPort() {
        return this.port;
    }

    @Override
    public int hashCode() {
        return 0;
    }
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
    @Override
    public String toString() {
        String s = "Port: " + this.port + " ConnectionClosed: " + this.closeConnection;
        return s;
    }
}
