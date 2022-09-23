package main;

import data.ClackData;

public class ClackServer {

    final int defaultPort = 7000;
    int port;
    boolean closeConnection;
    ClackData dataToReceiveFromClient;
    ClackData dataToSendToClient;

    ClackServer(int port) {
        this.port = port;
    }
    ClackServer() {
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
        if (o == this) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return null;
    }
}
