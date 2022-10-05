package main;

import test.TestClackClient;
import test.TestClackData;
import test.TestClackServer;

public class Main {
    public static void main(String[] args){
        TestClackClient testCC = new TestClackClient();
        TestClackData testCD = new TestClackData();
        TestClackServer testCS = new TestClackServer();

        if (testCC.testClackClient() != false) {
            System.out.println("Clack Client Failed!\n");
        }
        else {
            System.out.println("Clack Client Succeeded!\n");
        }
        if (testCD.testClackData() != false) {
            System.out.println("Clack Data Failed!\n");
        }
        else {
            System.out.println("Clack Data Succeeded!\n");
        }
        if (testCS.testClackServer() != false) {
            System.out.println("Clack Server Failed!\n");
        }
        else {
            System.out.println("Clack Server Succeeded!\n");
        }
    }
}
