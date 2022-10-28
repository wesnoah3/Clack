package test;

import main.ClackClient;

public class TestClackClient {

    public TestClackClient() {}
    public static void main(String[] args) {
        System.out.println("ClackClient Testing #1:");
        try {
            ClackClient cc1 = new ClackClient();
            System.out.println(cc1.getUserName());
            System.out.println(cc1.getHostName());
            System.out.println(cc1.getPort());
            System.out.println(cc1);
            System.out.println(cc1.hashCode());
            System.out.println("");
            cc1.start();

            System.out.println("ClackClient Testing #2:");
            ClackClient cc2 = new ClackClient("Test2");
            System.out.println(cc2.getUserName());
            System.out.println(cc2.getHostName());
            System.out.println(cc2.getPort());
            System.out.println(cc2);
            System.out.println(cc2.equals(cc1));
            System.out.println(cc2.hashCode());
            System.out.println("");

            System.out.println("ClackClient Testing #3:");
            ClackClient cc3 = new ClackClient("Test3", "hostname");
            System.out.println(cc3.getUserName());
            System.out.println(cc3.getHostName());
            System.out.println(cc3.getPort());
            System.out.println(cc3);
            System.out.println(cc3.equals(cc1));
            System.out.println(cc3.hashCode());
            System.out.println("");
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create ClackClient: " + e.getMessage());
        }

        System.out.println("ClackClient Testing #4:");
        try {
            ClackClient cc4 = new ClackClient("Test4", "hostname", 2345);
            System.out.println(cc4.getUserName());
            System.out.println(cc4.getHostName());
            System.out.println(cc4.getPort());
            System.out.println(cc4);
            System.out.println(cc4.hashCode());
            System.out.println("");
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to create ClackClient: " + e.getMessage());
        }

        System.out.println("ClackClient Testing #5:");
        try {
            ClackClient cc5 = new ClackClient("Test5", null);
            System.out.println(cc5);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to create ClackClient: " + e.getMessage());
        }

        System.out.println("ClackClient Testing #6:");
        try {
            ClackClient cc6 = new ClackClient("Test6", "hostname", 1234);
            System.out.println(cc6);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to create ClackClient: " + e.getMessage());
        }
    }
}
