package workspace.projects.madaData.Translating;

import workspace.projects.madaData.People.Person;

import java.io.IOException;
import java.util.HashSet;

public abstract class DataTranslator {
    String fileBase;
    FileManager manager;
    int maxRecords;


    public DataTranslator(String fileBase, FileManager manager, int maxRecords) {
        this.fileBase = fileBase;
        this.manager = manager;
        this.maxRecords = maxRecords;
    }


    /**
     * Moves the data from the HashSet to File(s)
     *
     * @param people The HashSet of Person instances
     */
    public abstract void translate(HashSet<? extends Person> people) throws IOException, FileNotDeletedException;

}
