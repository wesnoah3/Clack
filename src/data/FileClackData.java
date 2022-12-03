package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Class building off ClackData to store basic user variables and manage their files.
 */
public class FileClackData extends ClackData {
    /**
     * String representing the name of the file.
     */
    private String fileName;
    /**
     * String representing the contents of the file.
     */
    private String fileContents;
    /**
     * Ctor accepting userName, fileName, and type.
     * @param userName User's userName.
     * @param fileName User's fileName.
     * @param type User's type.
     */
    public FileClackData(String userName, String fileName, int type) {
        super(userName, type);
        this.fileName = fileName;
        this.fileContents = null;
    }
    /**
     * Default ctor.
     */
    public FileClackData() {
        super(ClackData.CONSTANT_SENDFILE);
        this.fileName = "";
        this.fileContents = null;
    }
    /**
     * Sets fileName to passed fileName.
     * @param fileName User's new fileName.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * Gets fileName String.
     * @return fileName String.
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Decrypts and returns fileContents with given key.
     * @param key
     * @return Decrypted file contents
     */
    public String getData(String key) {
        return decrypt(this.fileContents, key);
    }

    /**
     * Gets fileContents String.
     * @return fileContents String
     */
    public String getData() {
        return this.fileContents;
    }

    /**
     * Reads file contents after decrypting with given key.
     * @param key
     * @throws IOException
     */
    public void readFileContents(String key) throws IOException {
        List<String> contents = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(this.fileName)));
            String line = "";
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

        for (String s : contents) {
            fileContents += encrypt(s, key);
        }
    }

    /**
     * Reads file contents.
     * @throws IOException
     */
    public void readFileContents() throws IOException {
        List<String> contents = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(this.fileName)));
            String line = "";
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    /**
     * Writes fileContents after decrypting with given key.
     * @param key
     */
    public void writeFileContents(String key) {
        try {
            FileWriter fw = new FileWriter(this.fileName);
            String decrypted = decrypt(this.fileContents, key);
            fw.write(decrypted);
            fw.close();
        } catch (IOException e) {
            System.err.println("Error occurred writing encrypted data to file.");
            e.printStackTrace();
        }
    }

    /**
     * Writes file contents.
     */
    public void writeFileContents() {
        try {
            FileWriter fw = new FileWriter(this.fileName);
            fw.write(this.fileContents);
            fw.close();
        } catch (IOException e) {
            System.err.println("Error occurred writing data to file.");
        } catch (NullPointerException n) {
            System.err.println("Null pointer");
        }
    }
    /**
     * Returns unique hashCode of object using fileName and fileContents.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.username, this.type, this.fileName, this.fileContents);
    }
    /**
     * Takes object, returns true if its equal to this.
     * @param o Passed object to compare.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FileClackData)) {
            return false;
        }

        FileClackData otherFileClackData = (FileClackData) o;

        return this.username.equals(otherFileClackData.username)
                && this.type == otherFileClackData.type
                && Objects.equals(this.fileName, otherFileClackData.fileName)
                && Objects.equals(this.fileContents, otherFileClackData.fileContents);
    }
    /**
     * Generate message including all object data
     * @return Message String
     */
    @Override
    public String toString() {
        return "This instance of FileClackData has the following properties:\n"
                + "Username: " + this.username + "\n"
                + "Type: " + this.type + "\n"
                + "Date: " + this.date.toString() + "\n"
                + "File Name: " + this.fileName + "\n"
                + "File Contents: " + this.fileContents + "\n";
    }
}
