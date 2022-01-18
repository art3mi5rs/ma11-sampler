package workspace.projects.madaData.Translating;

import workspace.projects.madaData.Entities.Entity;
import workspace.projects.madaData.Translating.Managers.FileManager;

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
     * @param entities The LinkedHashSet of Entity instances
     */
    public abstract void translate(LinkedHashSet<? extends Entity> entities) throws IOException, FileNotDeletedException;

}
