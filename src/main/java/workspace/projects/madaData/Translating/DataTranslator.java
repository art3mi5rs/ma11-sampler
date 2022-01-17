package workspace.projects.madaData.Translating;

import workspace.projects.madaData.People.Person;

import java.io.IOException;
import java.util.LinkedHashSet;

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
     * Moves the data from the LinkedHashSet to File(s)
     *
     * @param people The LinkedHashSet of Person instances
     */
    public abstract void translate(LinkedHashSet<? extends Person> people) throws IOException, FileNotDeletedException;

}
