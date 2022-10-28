package test;

import data.ClackData;
import data.FileClackData;
import data.MessageClackData;

import java.io.IOException;

public class TestClackData {
    //This file should test all MessageClackData and FileClackData methods
    public static void main(String[] args) {
        //Testing FileClackData
        ClackData cd1 = new FileClackData("Test1", "C:\\Users\\wesba\\Desktop\\CS242-Clack\\test1.txt", 0);
        try {
            ((FileClackData) cd1).readFileContents();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        ClackData fcd1 = new FileClackData("Test2", "C:\\Users\\wesba\\Desktop\\CS242-Clack\\test2.txt", 0);

        ((FileClackData) fcd1).writeFileContents();

        System.out.println(cd1.getType());
        System.out.println(cd1.getUserName());
        System.out.println(cd1.getDate());
        System.out.println(cd1.getData());
        System.out.println(cd1.toString());
        System.out.println(cd1.hashCode());
        System.out.println("");

        System.out.println(fcd1.toString());

        System.out.println("ClackData Testing #2:");
        ClackData cd2 = new FileClackData();
        System.out.println(cd2.getType());
        System.out.println(cd2.getUserName());
        System.out.println(cd2.getDate());
        System.out.println(cd2.getData());
        System.out.println(cd2.toString());
        System.out.println(cd2.equals(cd1));
        System.out.println(cd2.hashCode());
        System.out.println("");

        System.out.println("ClackData Testing #3:");
        ClackData cd3 = new MessageClackData("Test3", "Secret Message", 0);
        System.out.println(cd3.getType());
        System.out.println(cd3.getUserName());
        System.out.println(cd3.getDate());
        System.out.println(cd3.getData());
        System.out.println(cd3.toString());
        System.out.println(cd3.hashCode());
        System.out.println("");

        System.out.println("ClackData Testing #4:");
        ClackData cd4 = new MessageClackData();
        System.out.println(cd4.getType());
        System.out.println(cd4.getUserName());
        System.out.println(cd4.getDate());
        System.out.println(cd4.getData());
        System.out.println(cd4.toString());
        System.out.println(cd4.equals(cd3));
        System.out.println(cd4.hashCode());
        System.out.println("");
    }
}
