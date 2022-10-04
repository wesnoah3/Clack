package test;

import data.FileClackData;
import data.MessageClackData;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TestClackData {
    //This file should test all MessageClackdata and FileClackData methods
    public boolean testClackData() {
        boolean failed = false;

        //Test all functions within ClackData

        final String username1 = "test1";
        final String username2 = "test2";
        final String fileName = "file1";
        final String msg1 = "This is a test";
        final int port1 = 1;
        final int port2 = 2;
        final String file1 = "testFile";
        final String fileContents = "asdfghjkl";
//        final Date day = Date.;
        final int code = 12345;

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
//        else if (mcd.getDate() != day){
//
//        }
        else if (mcd.hashCode() != code){
            failed = true;
        }
        else if (mcd.equals(msg1) != true){
            failed = true;
        }
        else if (mcd.toString() != username1){
            failed = true;
        }
//        else if(fcd.setFileName(fileName) != ){
//
//        }
        else if (fcd.getFileName() != fileName){
            failed = true;
        }
        else if (fcd.getData() != fileContents){
            failed = true;
        }

        //Still need to test FileClackData methods:  read and writeFileContents (They just return Void so ave to decide how to test)

        else if (fcd.hashCode() != code){
            failed = true;
        }
        else if(equals(msg1) != true){
            failed = true;
        }
        else if(fcd.toString() != username1) {
            failed = true;
        }

        return failed;
    }
}
