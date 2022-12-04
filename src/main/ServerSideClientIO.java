package main;

import data.ClackData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerSideClientIO implements Runnable {
    /**
     * Boolean repsenting whether the connection is closed.
     */
    private Boolean closeConnection = false;
    /**
     * ClackData object to hold data received from client.
     */
    private ClackData dataToReceiveFromClient;
    /**
     * ClackData object to hold data sent to client.
     */
    private ClackData dataToSendToClient;
    /**
     * ObjectInputStream object to receive information from the client.
     */
    private ObjectInputStream inFromClient;
    /**
     * ObjectInputStream object to send information to the client.
     */
    private ObjectOutputStream outToClient;
    /**
     * ClackServer object meant for the main server.
     */
    private ClackServer server;
    /**
     * Socket object meant for the socket accepted from the client.
     */
    private Socket clientSocket;

    /**
     * Constructor taking in ClackServer and Socket object.
     * @param server
     * @param clientSocket
     */
    public ServerSideClientIO(ClackServer server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
        inFromClient = null;
        outToClient = null;
    }

    /**
     * Overriden required method for Runnable interface.
     */
    @Override
    public void run() {
        try {
            outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
            inFromClient = new ObjectInputStream(clientSocket.getInputStream());

            while (!closeConnection) {
                this.receiveData();
                if (dataToReceiveFromClient.getType() != ClackData.CONSTANT_LISTUSERS) {
                    this.server.broadcast(dataToReceiveFromClient);
                }
                this.sendData();
            }
        } catch (NoRouteToHostException nrthe) {
            System.err.println("No Route To Host Exception occurred");
        } catch (UnknownHostException uhe) {
            System.err.println("Unknown Host Exception occurred");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        }
    }

    /**
     * Receives data from the client.
     */
    public void receiveData() {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
            if (dataToReceiveFromClient.getData().equals("DONE")) {
                closeConnection = true;
                server.remove(this);
            }
        } catch (NoRouteToHostException nrthe) {
            System.err.println("No route to host exception occurred");
        } catch (UnknownHostException uhe) {
            System.err.println("Unknown host exception occurred");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Class not found exception occurred");
        }
    }

    /**
     * Sends data to the client.
     */
    public void sendData() {
        try {
            outToClient.writeObject(dataToSendToClient);
        } catch (NoRouteToHostException nrthe) {
            System.err.println("No route to host exception occurred");
        } catch (UnknownHostException uhe) {
            System.err.println("Unknown host exception occurred");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        }
    }

    /**
     * Method to set the dataToSendToClient local variable.
     * @param dataToSendToClient
     */
    public void setDataToSendToClient(ClackData dataToSendToClient) {
        this.dataToSendToClient = dataToSendToClient;
    }

    public String getUsername() {
        return this.dataToReceiveFromClient.getUserName();
    }
}
