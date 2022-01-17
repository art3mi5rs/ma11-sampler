package workspace.projects.madaData.Translating;

public class FileNotDeletedException extends Exception {

    public FileNotDeletedException(String fileName){
        super(String.format("The file %s was not deleted", fileName));
    }
}
