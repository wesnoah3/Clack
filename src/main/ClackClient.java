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

    public ClackClient(String userName, String hostName, int port) {
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
    }

    public ClackClient(String userName, String hostName) {
        this.userName = userName;
        this.hostName = hostName;
    }

    public ClackClient(String userName) {
        this.userName = userName;
    }

    public ClackClient() {
        //Should call another ctor.. but what ctor
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
        if (o instanceof ClackClient) {
            ClackClient input = (ClackClient) o;
            if (this.userName == input.userName && this.hostName == input.hostName && this.port == input.port) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String s = "Username: " + this.userName + " HostName: " + this.hostName + " Port: " + this.port;
        return s;
    }
}
