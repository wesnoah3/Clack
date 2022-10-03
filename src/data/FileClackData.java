package data;

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
        this.fileContents = null;
    }
    /**
     * Default ctor.
     */
    public FileClackData() {
        super();
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
        return this.fileName.hashCode() + this.fileContents.hashCode();
    }
    /**
     * Takes object, returns true if its equal to this.
     * @param o Passed object to compare.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof FileClackData) {
            FileClackData input = (FileClackData) o;
            if (this.username == input.username && this.type == input.type && this.fileName == input.fileName && this.fileContents == input.fileContents) {
                return true;
            }
        }
        return false;
    }
    /**
     * Generate message including all object data
     * @return Message String
     */
    @Override
    public String toString() {
        String s = "Username: " + this.username + " Type: " + this.type + " FileName: " + this.fileName + " FileContents: " + this.fileContents;
        return s;
    }
}
