package test;

import main.ClackClient;

public class TestClackClient {

    public TestClackClient() {}
    public boolean testClackClient() {
        boolean failed = false;
        final String username1 = "test1";
        final String hostname1 = "host1";
        final int port1 = 10;

        ClackClient cc1 = new ClackClient(username1, hostname1, port1);
        ClackClient cc2 = new ClackClient(username1, hostname1, port1);

        if (cc1.getUserName() != username1) {
            failed = true;
        }
        else if (cc1.getHostName() != hostname1) {
            failed = true;
        }
        else if (cc1.getPort() != port1) {
            failed = true;
        }
        else if (cc1.hashCode() != cc2.hashCode()) {
            failed = true;
        }
        else if (cc1.equals(cc2) != true) {
            failed = true;
        }

        return failed;
    }
}
