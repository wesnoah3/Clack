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
    /**
     * A string representing the name of the client user.
     */
    String username;
    /**
     * An integer representing the kind of data exchanged between the client and the server.
     */
    int type;
    /**
     * A Date object representing the date and time when ClackData object is created.
     */
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
     * Encrypts given string with given key with the Vigenère Cipher
     * @param inputStringToEncrypt
     * @param key
     * @return
     */
    protected String encrypt(String inputStringToEncrypt, String key) {
        StringBuffer sb = new StringBuffer(inputStringToEncrypt);
        for (int i = 0; i < inputStringToEncrypt.length(); i++) {
            if (Character.isLowerCase(inputStringToEncrypt.charAt(i))) {
                sb.setCharAt(i, Character.toUpperCase(inputStringToEncrypt.charAt(i)));
            }
        }
        inputStringToEncrypt = sb.toString();

        String encryptedStr = "";

        for (int i = 0; i < inputStringToEncrypt.length(); i++) {
            int x = (inputStringToEncrypt.charAt(i) + key.charAt(i)) %26;

            x += 'A';

            encryptedStr += (char)(x);
        }

        return encryptedStr;
    }

    /**
     * Decrypts given string with given key with the Vigenère Cipher
     * @param inputStringToDecrypt
     * @param key
     * @return
     */
    protected String decrypt(String inputStringToDecrypt, String key) {
        StringBuffer sb = new StringBuffer(inputStringToDecrypt);
        for (int i = 0; i < inputStringToDecrypt.length(); i++) {
            if (Character.isLowerCase(inputStringToDecrypt.charAt(i))) {
                sb.setCharAt(i, Character.toUpperCase(inputStringToDecrypt.charAt(i)));
            }
        }
        inputStringToDecrypt = sb.toString();

        String decryptedStr = "";

        for (int i = 0; i < inputStringToDecrypt.length() && i < key.length(); i++) {
            int x = (inputStringToDecrypt.charAt(i) - key.charAt(i) + 26) %26;

            x += 'A';
            decryptedStr += (char)(x);
        }

        return decryptedStr;
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
