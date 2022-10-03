package data;

public class FileClackData extends ClackData {

    String fileName;
    String fileContents;
    /*
     * Ctor accepting userName, fileName, and type
     * @param userName
     * @param fileName
     * @param type
     */
    public FileClackData(String userName, String fileName, int type) {
        super(userName, type);
        this.fileContents = null;
    }
    /*
     * Default ctor
     */
    public FileClackData() {
        super();
    }
    /*
     * Sets fileName to passed fileName
     * @param fielName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /*
     * Returns fileName String
     */
    public String getFileName() {
        return this.fileName;
    }
    /*
     * Returns fileContents String
     */
    public String getData() {
        return this.fileContents;
    }
    /*
     * Reads file contents
     */
    public void readFileContents() {

    }
    /*
     * Writes file content
     */
    public void writeFileContents() {

    }
    /*
     * Returns unique hashCode of object using fileName and fileContents
     */
    @Override
    public int hashCode() {
        return this.fileName.hashCode() + this.fileContents.hashCode();
    }
    /*
     * Takes object, returns true if its equal to this
     * @param FileClackData object
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
    /*
     * Returns toStringed message including all object data
     */
    @Override
    public String toString() {
        String s = "Username: " + this.username + " Type: " + this.type + " FileName: " + this.fileName + " FileContents: " + this.fileContents;
        return s;
    }
}
