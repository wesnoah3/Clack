package data;

import java.util.Date;
/**
 * Abstract class to build FileClackData and MessageClackData off of.
 */
public abstract class ClackData {

    /**
     * For giving a listing of all users connected to this session.
     */
    public static final int CONSTANT_LISTUSERS = 0;

    /**
     * For logging out, i.e., close this client's connection.
     */
    public static final int CONSTANT_LOGOUT = 1;

    /**
     * For sending a message.
     */
    public static final int CONSTANT_SENDMESSAGE = 2;

    /**
     * For sending a file.
     */
    public static final int CONSTANT_SENDFILE = 3;
    String username;
    int type;
    Date date;
    /**
     * Ctor accepting userName and type.
     * @param userName User's username.
     * @param type User's type.
     */
    ClackData(String userName, int type) { //For Regular User
        this.username = userName;
        this.type = type;
        this.date = new Date();
    }
    /**
     * Ctor accepting type.
     * @param type User's type.
     */
    ClackData(int type) { //For "Anon" User
        this("Anon", type);
    }
    /**
     * Default ctor.
     */
    ClackData() {
        this(CONSTANT_LOGOUT);
    }
    /**
     * Gets type int.
     * @return type integer.
     */
    public int getType() {
        return this.type;
    }
    /**
     * Gets userName String.
     * @return userName String.
     */
    public String getUserName() {
        return this.username;
    }
    /**
     * Gets date object.
     * @return Stored date object.
     */
    public Date getDate() {
        return this.date;
    }
    /**
     * Abstract getData function to return contents.
     * @return Data String.
     */
    public abstract String getData();

}
