package test;

import data.FileClackData;
import data.MessageClackData;

public class TestClackData {

    public boolean testClackData() {

        boolean failed = false;

        MessageClackData mcd = new MessageClackData("test1", "This is a test", 1);
        FileClackData fcd = new FileClackData("test2", "testfile", 2);

        if (mcd.getUserName() != "test1") {
            failed = true;
        }
        else if (mcd.getData() != "This is a test") {
            failed = true;
        }
        else if (mcd.getType() != 1) {
            failed = true;
        }

        //else if (fcd.getFileName() != )




        return failed;
    }
}
