package data;

public class MessageClackData extends ClackData {

    String message;

    public MessageClackData(String userName, String message, int type) {
        super(userName, type);
        this.message = message;
    }
    public MessageClackData() {
        super();
    }

    public String getData() {
        return this.message;
    }

    @Override
    public int hashCode() {
        return 0;
    }

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

    @Override
    public String toString() {
        String s = "Username: " + this.username + " Type: " + this.type + " Message: " + this.message;
        return s;
    }
}
