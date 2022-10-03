package test;

import data.FileClackData;
import data.MessageClackData;

public class TestClackData {

    public boolean testClackData() {
        boolean failed = false;

        //Test all functions within ClackData

        final String username1 = "test1";
        final String username2 = "test2";
        final String msg1 = "This is a test";
        final int port1 = 1;
        final int port2 = 2;
        final String file1 = "testFile";

        MessageClackData mcd = new MessageClackData(username1, msg1, port1);
        FileClackData fcd = new FileClackData(username2, file1, port2);

        if (mcd.getUserName() != username1) {
            failed = true;
        }
        else if (mcd.getData() != msg1) {
            failed = true;
        }
        else if (mcd.getType() != port1) {
            failed = true;
        }




        return failed;
    }
}
