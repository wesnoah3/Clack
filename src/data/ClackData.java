package data;

import java.util.Date;
import java.io.Serializable;
/**
 * Abstract class to build FileClackData and MessageClackData off of.
 */
public abstract class ClackData implements Serializable {

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
        String encryptedStr = "";
        int index = 0;
        for (char ch : inputStringToEncrypt.toCharArray()) {
            Boolean flag = false;
            if (Character.isLetter(ch)) {
                flag = true;
                encryptedStr+= handleCaps(ch, key.charAt(index), true);
            } else {
                encryptedStr += ch;
            }
            if (flag) {
                if (index == key.length() - 1) {
                    index = 0;
                } else {
                    index++;
                }
            }
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
        String decryptedStr = "";
        int index = 0;
        for (char ch : inputStringToDecrypt.toCharArray()) {
            Boolean flag = false;
            if (Character.isLetter(ch)) {
                flag = true;
                decryptedStr += handleCaps(ch, key.charAt(index), false);
            } else {
                decryptedStr += ch;
            }
            if (flag) {
                if (index == key.length() - 1) {
                    index = 0;
                } else {
                    index++;
                }
            }
        }
        return decryptedStr;
    }

    private static char handleCaps(char inputChar, char keyChar, Boolean encrypt) {
        Boolean capitalize = false;
        if (Character.isUpperCase(inputChar)) {
            capitalize = true;
        }
        final char newChar = encrypt ? intToChar(findSmallest(charToInt(inputChar) + charToInt(keyChar) - 1))  : intToChar(findSmallest(charToInt(inputChar) - charToInt(keyChar) + 1));
        return capitalize ? Character.toUpperCase(newChar) : newChar;
    }

    private static char intToChar(int i) {
        return (char) (i + 96);
    }

    private static int charToInt(char ch) {
        return (int) Character.toLowerCase(ch) - 96;
    }

    private static int findSmallest(int i) {
        while (i < 0)
            i += 26;
        while (i > 26)
            i -= 26;
        if (i == 0)
            i = 26;
        return i;
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
