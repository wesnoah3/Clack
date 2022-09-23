package data;

import java.util.Date;
public class ClackData {

    String username;
    int type;
    Date date;

    ClackData(String userName, int type) { //For Regular User
        this.username = userName;
        this.type = type;
        this.date = new Date();
    }
    ClackData(int type) { //For "Anon" User

    }
    ClackData() {

    }

    public int getType() {
        return this.type;
    }
    public String getUserName() {
        return this.username;
    }
    public Date getDate() {
        return this.date;
    }
    /*
    public abstract String getData() {

    }
    */
}
