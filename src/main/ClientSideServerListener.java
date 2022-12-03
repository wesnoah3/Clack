package main;

public class ClientSideServerListener implements Runnable {
    /**
     * ClackClient object to receive and print data.
     */
    private ClackClient client = null;

    /**
     * Constructor that accepts ClackClient.
     * @param client
     */
    public ClientSideServerListener(ClackClient client) {
        this.client = client;
    }

    /**
     * Run method required for runnable interface, runs the thread. Receives data and prints data.
     */
    @Override
    public void run() {
        while (!client.getCloseConnection()) {
            client.receiveData();
            client.printData();
        }
    }
}
