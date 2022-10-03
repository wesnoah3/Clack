package data;

public class MessageClackData extends ClackData {

    String message;
    /*
     * Ctor for MessageClackData taking username, message, and type
     * @param userName
     * @param message
     * @param type
     */
    public MessageClackData(String userName, String message, int type) {
        super(userName, type);
        this.message = message;
    }
    /*
     * Default ctor for MesageClackData
     */
    public MessageClackData() {
        super();
    }
    /*
     * Returns message
     */
    public String getData() {
        return this.message;
    }
    /*
     * Returns hashCode of object
     */
    @Override
    public int hashCode() {
        return this.message.hashCode();
    }
    /*
     * Takes object, returns true if its equal to this
     * @param MessageClackData object
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
    /*
     * Returns toStringed message including all object data
     */
    @Override
    public String toString() {
        String s = "Username: " + this.username + " Type: " + this.type + " Message: " + this.message;
        return s;
    }
}
