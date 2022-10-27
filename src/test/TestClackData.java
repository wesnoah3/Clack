package test;

import data.ClackData;
import data.FileClackData;
import data.MessageClackData;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TestClackData {
    //This file should test all MessageClackdata and FileClackData methods
    public static void main(String[] args) {
        // MessageClackData (all constructors)
        MessageClackData messageClackData1 = new MessageClackData();
        MessageClackData messageClackData2 =
                new MessageClackData("testUser1", "testMessage", ClackData.CONSTANT_SENDMESSAGE);
        MessageClackData messageClackData3 = new MessageClackData("testUser3", "HelloWorld", "SecretKey", 400);

        // FileClackData (both constructors)
        FileClackData fileClackData1 = new FileClackData();
        FileClackData fileClackData2 =
                new FileClackData("testUser2", "filename0", ClackData.CONSTANT_SENDFILE);

        // getType()
        System.out.println("messageClackData1 getType(): " + messageClackData1.getType());
        System.out.println("messageClackData2 getType(): " + messageClackData2.getType());
        System.out.println("messageClackData3 getType(): " + messageClackData3.getType());
        System.out.println("fileClackData1 getType(): " + fileClackData1.getType());
        System.out.println("fileClackData2 getType(): " + fileClackData2.getType());
        System.out.println();

        // getUserName()
        System.out.println("messageClackData1 getUserName(): " + messageClackData1.getUserName());
        System.out.println("messageClackData2 getUserName(): " + messageClackData2.getUserName());
        System.out.println("messageClackData3 getUserName(): " + messageClackData3.getUserName());
        System.out.println("fileClackData1 getUserName(): " + fileClackData1.getUserName());
        System.out.println("fileClackData2 getUserName(): " + fileClackData2.getUserName());
        System.out.println();

        // getDate()
        System.out.println("messageClackData1 getDate(): " + messageClackData1.getDate());
        System.out.println("messageClackData2 getDate(): " + messageClackData2.getDate());
        System.out.println("messageClackData3 getDate(): " + messageClackData3.getDate());
        System.out.println("fileClackData1 getDate(): " + fileClackData1.getDate());
        System.out.println("fileClackData2 getDate(): " + fileClackData2.getDate());
        System.out.println();

        // getData()
        System.out.println("messageClackData1 getData(): " + messageClackData1.getData());
        System.out.println("messageClackData2 getData(): " + messageClackData2.getData());
        System.out.println("messageClackData3 getData(): " + messageClackData3.getData());
        System.out.println("fileClackData1 getData(): " + fileClackData1.getData());
        System.out.println("fileClackData2 getData(): " + fileClackData2.getData());
        System.out.println();

        // hashCode()
        System.out.println("messageClackData1 hashCode(): " + messageClackData1.hashCode());
        System.out.println("messageClackData2 hashCode(): " + messageClackData2.hashCode());
        System.out.println("messageClackData3 hashCode(): " + messageClackData3.hashCode());
        System.out.println("fileClackData1 hashCode(): " + fileClackData1.hashCode());
        System.out.println("fileClackData2 hashCode(): " + fileClackData2.hashCode());
        System.out.println();

        // equals()
        System.out.println("messageClackData1 equals null: "
                + messageClackData1.equals(null));
        System.out.println("messageClackData1 equals messageClackData1: "
                + messageClackData1.equals(messageClackData1));
        System.out.println("messageClackData1 equals messageClackData2: "
                + messageClackData1.equals(messageClackData2));
        System.out.println("messageClackData2 equals messageClackData1: "
                + messageClackData2.equals(messageClackData1));
        System.out.println("messageClackData3 equals messageClackData1: "
                + messageClackData3.equals(messageClackData1));
        System.out.println("messageClackData1 equals fileClackData1: "
                + messageClackData1.equals(fileClackData1));
        System.out.println("fileClackData1 equals null: "
                + fileClackData1.equals(null));
        System.out.println("fileClackData1 equals fileClackData1: "
                + fileClackData1.equals(fileClackData1));
        System.out.println("fileClackData1 equals fileClackData2: "
                + fileClackData1.equals(fileClackData2));
        System.out.println("fileClackData2 equals fileClackData1: "
                + fileClackData2.equals(fileClackData1));
        System.out.println("fileClackData1 equals messageClackData1: "
                + fileClackData1.equals(messageClackData1));
        System.out.println();

        // toString()
        System.out.println("messageClackData1:\n" + messageClackData1);
        System.out.println("messageClackData2:\n" + messageClackData2);
        System.out.println("messageClackData3:\n" + messageClackData3);
        System.out.println("fileClackData1:\n" + fileClackData1);
        System.out.println("fileClackData2:\n" + fileClackData2);
        System.out.println();

        // getFileName
        System.out.println("fileClackData1 getFileName(): " + fileClackData1.getFileName());
        System.out.println("fileClackData2 getFileName(): " + fileClackData2.getFileName());
        System.out.println();

        // setFileName
        String filename1 = "filename1";
        System.out.println("Sets the filename of fileClackData1 to be " + filename1);
        fileClackData1.setFileName(filename1);
        System.out.println("fileClackData1 getFileName(): " + fileClackData1.getFileName());
        System.out.println("fileClackData1 hashCode(): " + fileClackData1.hashCode());
        System.out.println("fileClackData1 equals fileClackData1: " + fileClackData1.equals(fileClackData1));
        System.out.println("fileClackData1 equals fileClackData2: " + fileClackData1.equals(fileClackData2));
        System.out.println("fileClackData1:\n" + fileClackData1);
        System.out.println();

        String filename2 = "filename2";
        System.out.println("Sets the filename of fileClackData2 to be " + filename2);
        fileClackData2.setFileName(filename2);
        System.out.println("fileClackData2 getFileName(): " + fileClackData2.getFileName());
        System.out.println("fileClackData2 hashCode(): " + fileClackData2.hashCode());
        System.out.println("fileClackData2 equals fileClackData2: " + fileClackData2.equals(fileClackData2));
        System.out.println("fileClackData2 equals fileClackData1: " + fileClackData2.equals(fileClackData1));
        System.out.println("fileClackData2:\n" + fileClackData2);

        // decrypt
        System.out.println("messageClackData3 decrypted message: " + messageClackData3.getData("SecretKey"));
    }
}
