package data;

import java.util.Objects;
/**
 * Class building off ClackData to store basic user variable and manager their new messages.
 */
public class MessageClackData extends ClackData {

    private String message;  // A string representing instant message

    /**
     * The constructor to set up the instance variables username, message, and type.
     * Crypts and sets message with given key.
     * @param userName User's userName.
     * @param message User's message.
     * @param key User's key.
     * @param type User's type.
     */
    public MessageClackData(String userName, String message, String key, int type) {
        super(userName, type);
        this.message = encrypt(message, key);
    }

    /**
     * Ctor for MessageClackData taking username, message, and type.
     * @param userName User's userName.
     * @param message User's message.
     * @param type User's type.
     */
    public MessageClackData(String userName, String message, int type) {
        super(userName, type);
        this.message = message;
    }
    /**
     * Default ctor.
     */
    public MessageClackData() {
        super(ClackData.CONSTANT_SENDMESSAGE);
        this.message = "";
    }

    /**
     * Decrypts and returns message with given key.
     * @param key
     * @return Decrypted message.
     */
    public String getData(String key) {
        return decrypt(this.message, key);
    }
    /**
     * Gets message.
     * @return Stored message.
     */
    public String getData() {
        return this.message;
    }
    /**
     * Generated hashCode for object.
     * @return hashcode Integer.
     */
    @Override
    public int hashCode() {
        int result = 29;

        result = 37 * result + ((this.username == null) ? 0 : this.username.hashCode());
        result = 37 * result + this.type;
        result = 37 * result + ((this.message == null) ? 0 : this.message.hashCode());

        return result;
    }
    /**
     * Takes object, returns true if its equal to this
     * @param o Passed object to compare to.
     * @return Boolean representing whether the objects are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageClackData)) {
            return false;
        }

        MessageClackData otherMessageClackData = (MessageClackData) o;

        return this.username.equals(otherMessageClackData.username)
                && this.type == otherMessageClackData.type
                && Objects.equals(this.message, otherMessageClackData.message);
    }
    /**
     * Generates toStringed message including all object data.
     * @return toString String.
     */
    @Override
    public String toString() {
        return "This instance of MessageClackData has the following properties:\n"
                + "Username: " + this.username + "\n"
                + "Type: " + this.type + "\n"
                + "Date: " + this.date.toString() + "\n"
                + "Message: " + this.message + "\n";
    }
}
