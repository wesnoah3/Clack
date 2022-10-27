package data;

import java.util.Objects;
/**
 * Class building off ClackData to store basic user variables and manage their files.
 */
public class FileClackData extends ClackData {

    String fileName;
    String fileContents;
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
     * Gets fileContents String.
     * @return fileContents String
     */
    public String getData() {
        return this.fileContents;
    }
    /**
     * Reads file contents.
     */
    public void readFileContents() {

    }
    /**
     * Writes file contents.
     */
    public void writeFileContents() {

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
