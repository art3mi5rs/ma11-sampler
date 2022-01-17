package workspace.projects.madaData.Parsing;

import workspace.projects.madaData.Entities.Entity;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

public abstract class FileParser {

    /**
     * Reads the data from the file and puts it in a set
     *
     * @param file The dataFile
     * @return Returns a hash set with the data about the entities
     */
    public abstract LinkedHashSet<? extends Entity> parse(File file) throws IOException;

}
