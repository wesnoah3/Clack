package test;

import data.FileClackData;
import data.MessageClackData;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TestClackData {
    //This file should test all MessageClackdata and FileClackData methods

    public TestClackData() {}

    public boolean testClackData() {
        boolean failed = false;
        final String username1 = "test1";
        final String username2 = "test2";
        final String fileName = "file1";
        final String msg1 = "This is a test";
        final int type1 = 1;
        final int type2 = 2;
        final String file1 = "testFile";

        MessageClackData mcd1 = new MessageClackData(username1, msg1, type1);
        MessageClackData mcd2 = new MessageClackData(username1, msg1, type1);
        FileClackData fcd1 = new FileClackData(username2, file1, type2);
        FileClackData fcd2 = new FileClackData(username2, file1, type2);

        fcd1.setFileName(fileName);

        if (mcd1.getUserName() != username1) {
            failed = true;
        }
        else if (mcd1.getData() != msg1) {
            failed = true;
        }
        else if (!(mcd1.getDate() instanceof Date)) {
            failed = true;
        }
        else if (mcd1.getType() != type1) {
            failed = true;
        }
        else if (mcd1.hashCode() != mcd2.hashCode()){
            failed = true;
        }
        else if (mcd1.equals(mcd2) != true) {
            failed = true;
        }
        else if (fcd1.getFileName() != fileName){
            failed = true;
        }
        else if (fcd1.equals(fcd2) != false) {
            failed = true;
        }

        return failed;
    }
}
