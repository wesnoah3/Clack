package test;

import main.ClackClient;

public class TestClackClient {

    public TestClackClient() {}
    public static void main(String[] args) {
        // All four constructors of ClackClient
        ClackClient clackClient1 = new ClackClient("testUser1", "hostName1", 12345);
        ClackClient clackClient2 = new ClackClient("testUser2", "hostName2", 7000);
        ClackClient clackClient3 = new ClackClient("testUser3", "localhost", 7000);
        ClackClient clackClient4 = new ClackClient("Anon", "localhost", 7000);
        ClackClient clackClient5 = new ClackClient("testUser2", "hostName2");
        ClackClient clackClient6 = new ClackClient("testUser3", "localhost");
        ClackClient clackClient7 = new ClackClient("Anon", "localhost");
        ClackClient clackClient8 = new ClackClient("testUser3");
        ClackClient clackClient9 = new ClackClient("Anon");
        ClackClient clackClient10 = new ClackClient();
        ClackClient clackClient11 = new ClackClient(null);

        // getUserName()
        System.out.println("clackClient1 getUserName(): " + clackClient1.getUserName());
        System.out.println("clackClient2 getUserName(): " + clackClient2.getUserName());
        System.out.println("clackClient3 getUserName(): " + clackClient3.getUserName());
        System.out.println("clackClient4 getUserName(): " + clackClient4.getUserName());
        System.out.println("clackClient5 getUserName(): " + clackClient5.getUserName());
        System.out.println("clackClient6 getUserName(): " + clackClient6.getUserName());
        System.out.println("clackClient7 getUserName(): " + clackClient7.getUserName());
        System.out.println("clackClient8 getUserName(): " + clackClient8.getUserName());
        System.out.println("clackClient9 getUserName(): " + clackClient9.getUserName());
        System.out.println("clackClient10 getUserName(): " + clackClient10.getUserName());
        System.out.println("clackClient11 getUserName(): " + clackClient11.getUserName());
        System.out.println();

        // getHostName()
        System.out.println("clackClient1 getHostName(): " + clackClient1.getHostName());
        System.out.println("clackClient2 getHostName(): " + clackClient2.getHostName());
        System.out.println("clackClient3 getHostName(): " + clackClient3.getHostName());
        System.out.println("clackClient4 getHostName(): " + clackClient4.getHostName());
        System.out.println("clackClient5 getHostName(): " + clackClient5.getHostName());
        System.out.println("clackClient6 getHostName(): " + clackClient6.getHostName());
        System.out.println("clackClient7 getHostName(): " + clackClient7.getHostName());
        System.out.println("clackClient8 getHostName(): " + clackClient8.getHostName());
        System.out.println("clackClient9 getHostName(): " + clackClient9.getHostName());
        System.out.println("clackClient10 getHostName(): " + clackClient10.getHostName());
        System.out.println("clackClient11 getHostName(): " + clackClient11.getHostName());
        System.out.println();

        // getPort()
        System.out.println("clackClient1 getPort(): " + clackClient1.getPort());
        System.out.println("clackClient2 getPort(): " + clackClient2.getPort());
        System.out.println("clackClient3 getPort(): " + clackClient3.getPort());
        System.out.println("clackClient4 getPort(): " + clackClient4.getPort());
        System.out.println("clackClient5 getPort(): " + clackClient5.getPort());
        System.out.println("clackClient6 getPort(): " + clackClient6.getPort());
        System.out.println("clackClient7 getPort(): " + clackClient7.getPort());
        System.out.println("clackClient8 getPort(): " + clackClient8.getPort());
        System.out.println("clackClient9 getPort(): " + clackClient9.getPort());
        System.out.println("clackClient10 getPort(): " + clackClient10.getPort());
        System.out.println("clackClient11 getPort(): " + clackClient11.getPort());
        System.out.println();

        // hashCode()
        System.out.println("clackClient1 hashCode(): " + clackClient1.hashCode());
        System.out.println("clackClient2 hashCode(): " + clackClient2.hashCode());
        System.out.println("clackClient3 hashCode(): " + clackClient3.hashCode());
        System.out.println("clackClient4 hashCode(): " + clackClient4.hashCode());
        System.out.println("clackClient5 hashCode(): " + clackClient5.hashCode());
        System.out.println("clackClient6 hashCode(): " + clackClient6.hashCode());
        System.out.println("clackClient7 hashCode(): " + clackClient7.hashCode());
        System.out.println("clackClient8 hashCode(): " + clackClient8.hashCode());
        System.out.println("clackClient9 hashCode(): " + clackClient9.hashCode());
        System.out.println("clackClient10 hashCode(): " + clackClient10.hashCode());
        System.out.println("clackClient11 hashCode(): " + clackClient11.hashCode());
        System.out.println();

        // equals()
        System.out.println("clackServer1 equals null: " + clackClient1.equals(null));
        System.out.println("clackServer1 equals clackServer1: " + clackClient1.equals(clackClient1));
        System.out.println("clackServer1 equals clackServer2: " + clackClient1.equals(clackClient2));
        System.out.println("clackServer1 equals clackServer3: " + clackClient1.equals(clackClient3));
        System.out.println("clackServer1 equals clackServer4: " + clackClient1.equals(clackClient4));
        System.out.println("clackServer1 equals clackServer5: " + clackClient1.equals(clackClient5));
        System.out.println("clackServer1 equals clackServer6: " + clackClient1.equals(clackClient6));
        System.out.println("clackServer1 equals clackServer7: " + clackClient1.equals(clackClient7));
        System.out.println("clackServer1 equals clackServer8: " + clackClient1.equals(clackClient8));
        System.out.println("clackServer1 equals clackServer9: " + clackClient1.equals(clackClient9));
        System.out.println("clackServer1 equals clackServer10: " + clackClient1.equals(clackClient10));
        System.out.println("clackServer2 equals clackServer1: " + clackClient2.equals(clackClient1));
        System.out.println("clackServer5 equals clackServer2: " + clackClient5.equals(clackClient2));
        System.out.println("clackServer5 equals clackServer6: " + clackClient5.equals(clackClient6));
        System.out.println("clackServer6 equals clackServer3: " + clackClient6.equals(clackClient3));
        System.out.println("clackServer7 equals clackServer4: " + clackClient7.equals(clackClient4));
        System.out.println("clackServer8 equals clackServer3: " + clackClient8.equals(clackClient3));
        System.out.println("clackServer8 equals clackServer6: " + clackClient8.equals(clackClient6));
        System.out.println("clackServer8 equals clackServer9: " + clackClient8.equals(clackClient9));
        System.out.println("clackServer9 equals clackServer4: " + clackClient9.equals(clackClient4));
        System.out.println("clackServer9 equals clackServer7: " + clackClient9.equals(clackClient7));
        System.out.println("clackServer10 equals clackServer4: " + clackClient10.equals(clackClient4));
        System.out.println("clackServer10 equals clackServer7: " + clackClient10.equals(clackClient7));
        System.out.println("clackServer10 equals clackServer9: " + clackClient10.equals(clackClient9));
        // System.out.println("clackServer1 equals clackServer11: " + clackClient1.equals(clackClient11));
        // System.out.println("clackServer11 equals clackServer1: " + clackClient11.equals(clackClient1));
        System.out.println();

        // toString()
        System.out.println("clackClient1:\n" + clackClient1);
        System.out.println("clackClient2:\n" + clackClient2);
        System.out.println("clackClient3:\n" + clackClient3);
        System.out.println("clackClient4:\n" + clackClient4);
        System.out.println("clackClient5:\n" + clackClient5);
        System.out.println("clackClient6:\n" + clackClient6);
        System.out.println("clackClient7:\n" + clackClient7);
        System.out.println("clackClient8:\n" + clackClient8);
        System.out.println("clackClient9:\n" + clackClient9);
        System.out.println("clackClient10:\n" + clackClient10);
        System.out.println("clackClient11:\n" + clackClient10);
    }
}
