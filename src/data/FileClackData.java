package data;

public class FileClackData extends ClackData {

    String fileName;
    String fileContents;
    public FileClackData(String userName, String fileName, int type) {
        super(userName, type);
        this.fileContents = null;
    }

    public FileClackData() {
        super();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return this.fileName;
    }
    public String getData() {
        return this.fileContents;
    }
    public void readFileContents() {

    }
    public void writeFileContents() {

    }
    @Override
    public int hashCode() {
        return 0;
    }
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
    @Override
    public String toString() {
        String s = "Username: " + this.username + " Type: " + this.type + " FileName: " + this.fileName + " FileContents: " + this.fileContents;
        return s;
    }
}
