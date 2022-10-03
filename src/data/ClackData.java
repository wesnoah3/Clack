package data;

import java.util.Date;
public abstract class ClackData {

    String username;
    int type;
    Date date;
    /*
     * Ctor accepting userName and type
     * @param userName
     * @param type
     */
    ClackData(String userName, int type) { //For Regular User
        this.username = userName;
        this.type = type;
        this.date = new Date();
    }
    /*
     * Ctor accepting type
     */
    ClackData(int type) { //For "Anon" User
    }
    /*
     * Default ctor
     */
    ClackData() {

    }
    /*
     * Returns type int
     */
    public int getType() {
        return this.type;
    }
    /*
     * Returns userName String
     */
    public String getUserName() {
        return this.username;
    }
    /*
     * Returns stored date object
     */
    public Date getDate() {
        return this.date;
    }
    /*
     * Abstract getData function to return contents
     */
    public abstract String getData();

}
