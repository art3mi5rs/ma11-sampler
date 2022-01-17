package workspace.projects.madaData.Translating;

public class FileNotDeletedException extends Exception {
    String fileName;

    public FileNotDeletedException(String fileName){
        this.fileName = fileName;
    }
}
