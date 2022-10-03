package data;

/**
 * Class building off ClackData to store basic user variable and manager their new messages.
 */
public class MessageClackData extends ClackData {

    String message;
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
        super();
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
        return this.message.hashCode();
    }
    /**
     * Takes object, returns true if its equal to this
     * @param o Passed object to compare to.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof MessageClackData) {
            MessageClackData input = (MessageClackData) o;
            if (this.username == input.username && this.type == input.type && this.message == input.message) {
                return true;
            }
        }
        return false;
    }
    /**
     * Generates toStringed message including all object data.
     * @return toString String.
     */
    @Override
    public String toString() {
        String s = "Username: " + this.username + " Type: " + this.type + " Message: " + this.message;
        return s;
    }
}
