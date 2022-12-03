package main;

import data.ClackData;
import data.ListUsersClackData;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class to store and maintain all relevant ClackServer data.
 */
public class ClackServer {
    /**
     * Default port
     */
    private static final int DEFAULT_PORT = 7000;
    /**
     * Integer representing port number.
     */
    private int port;
    /**
     * Boolean representing whether connection is closed or not.
     */
    private boolean closeConnection;
    /**
     * ArrayList of ServerSideClientIO objects.
     */
    private ArrayList<ServerSideClientIO> serverSideClientIOList;
    /**
     * List of current users.
     */
    public ListUsersClackData listUsersClackData;
    /**
     * Ctor accepting port.
     * @param port User's port.
     */
    public ClackServer(int port) {
        if (port < 1024) {
            throw new IllegalArgumentException("Port must be greater than 1024");
        }
        this.port = port;
        this.closeConnection = false;
        serverSideClientIOList = new ArrayList<ServerSideClientIO>();
        listUsersClackData = new ListUsersClackData();
    }
    /**
     * Default ctor.
     */
    public ClackServer() {
        this(DEFAULT_PORT);
    }
    /**
     * Method to start ClackServer.
     */
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = null;
            while (!closeConnection) {
                clientSocket = serverSocket.accept();
                ServerSideClientIO serverSide = new ServerSideClientIO(this, clientSocket);
                serverSideClientIOList.add(serverSide);
                Thread serverSideThread = new Thread(serverSide);
                serverSideThread.start();
            }
            serverSocket.close();
            clientSocket.close();
        } catch (NoRouteToHostException nrthe) {
            System.err.println("No route to host exception occurred");
        } catch (UnknownHostException uhe) {
            System.err.println("Unknown host exception occurred");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        }
    }
    /**
     * Gets port.
     * @return port integer.
     */
    public int getPort() {
        return this.port;
    }
    public static void main(String args[]) {
        try {
            ClackServer server;
            if (args.length > 0) {
                final String passed = args[0];
                final int port = Integer.parseInt(passed);
                server = new ClackServer(port);
            } else {
                server = new ClackServer();
            }
            server.start();
        } catch (NumberFormatException nfe) {
            System.err.println("Number format exception occurred");
        }
    }
    /**
     * Method to get unique hashcode for each object.
     * @return Unique hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.port, this.closeConnection);
    }
    /**
     * Takes object, returns true if its equal to this.
     * @param o Passed object to compare to.
     * @return Whether the objects are equal
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
                && this.closeConnection == otherClackServer.closeConnection;
    }
    /**
     * Genereates toStringed message including all object data.
     * @return toString String.
     */
    @Override
    public String toString() {
        return "This instance of ClackServer has the following properties:\n"
                + "Port number: " + this.port + "\n"
                + "Connection status: " + (this.closeConnection ? "Closed" : "Open") + "\n";
    }

    /**
     * Broadcasts ServerSideClientIO data.
     * @param dataToBroadcastToClients
     */
    public synchronized void broadcast(ClackData dataToBroadcastToClients) {
        for (ServerSideClientIO client : serverSideClientIOList) {
            client.setDataToSendToClient(dataToBroadcastToClients);
            client.sendData();
        }
    }

    /**
     * Helper function to remove specfic ServerSideClientIO object from list.
     * @param serverSideClientToRemove
     */
    public synchronized void remove(ServerSideClientIO serverSideClientToRemove) {
        serverSideClientIOList.remove(serverSideClientToRemove);
    }
}
