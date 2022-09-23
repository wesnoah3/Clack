package main;

import data.ClackData;

public class ClackClient {
    String userName;
    String hostName;
    int port;
    boolean closeConnection;
    ClackData dataToSendToServer;
    ClackData dataToReceiveFromServer;

    ClackClient(String userName, String hostName, int port) {
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
    }

    ClackClient(String userName, String hostName) {
        this.userName = userName;
        this.hostName = hostName;
    }

    ClackClient(String userName) {
        this.userName = userName;
    }

    ClackClient() {

    }

    public void start() {

    }
    public void readClientData() {

    }
    public void sendData() {

    }
    public void receiveData() {

    }
    public void printData() {

    }
    public String getUserName() {
        return this.userName;
    }
    public String getHostName() {
        return this.hostName;
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
        else {
            return false;
        }
    }
    @Override
    public String toString() {
        return null;
    }
}
