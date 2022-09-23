package data;

public class FileClackData extends ClackData {

    String fileName;
    String fileContents;
    FileClackData(String userName, String fileName, int type) {
        super(userName, type);
        this.fileContents = null;
    }

    FileClackData() {
        super();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }
    public String getData() {
        return fileContents;
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
        if (o == this) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public String toString() {
        return null;
    }
}
