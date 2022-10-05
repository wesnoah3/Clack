package test;

import main.ClackServer;

public class TestClackServer {

    public TestClackServer() {}
    public boolean testClackServer() {
        boolean failed = false;
        final int port1 = 25;

        ClackServer cs1 = new ClackServer(port1);
        ClackServer cs2 = new ClackServer(port1);
        ClackServer cs3 = new ClackServer();

        if (cs1.getPort() != port1) {
            failed = true;
        }
        else if (cs3.getPort() != 7000) {
            failed = true;
        }
        else if (cs1.hashCode() != cs2.hashCode()) {
            failed = true;
        }
        else if (cs1.equals(cs2) != true) {
            failed = true;
        }
        else if (cs1.equals(cs3) != false) {
            failed = true;
        }

        return failed;
    }
}
