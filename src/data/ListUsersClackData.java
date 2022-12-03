package data;

import java.util.ArrayList;

public class ListUsersClackData extends ClackData {
    /**
     * ArrayList representing the users connected to server.
     */
    private ArrayList<String> userList;

    /**
     * Constructor accepting username and type.
     * @param userName
     * @param type
     */
    public ListUsersClackData(String userName, int type) {
        super(userName, type);
        userList = new ArrayList<String>();
    }

    /**
     * Default constructor.
     */
    public ListUsersClackData() {
        this("Anon", CONSTANT_LISTUSERS);
    }

    /**
     * Helper function to add user to list.
     * @param userName
     */
    public synchronized void addUser(String userName) {
        if (!userList.contains(userName)) {
            userList.add(userName);
        }
    }

    /**
     * Helper function to remove user from list.
     * @param userName
     */
    public synchronized void removeUser(String userName) {
        if (userList.contains(userName)) {
            userList.remove(userName);
        }
    }
    /**
     * Returns userList with commas.
     * @return userList
     */
    public String getData() {
        String str = "";
        for (String user : userList) {
            str += user;
            str += ",";
        }
        if (!str.isEmpty()) {
            str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Override
    public String toString() {
        return "ListUsers [" + getData() + "]";
    }
}
