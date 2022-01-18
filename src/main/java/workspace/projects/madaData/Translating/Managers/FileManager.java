package workspace.projects.madaData.Translating.Managers;

import workspace.projects.madaData.Translating.FileNotDeletedException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FileManager {

    /**
     * Creates a new Writer and opens ana array for the records
     *
     * @param filePath The path of the file to delete
     * @return Returns a new FileWriter
     * @throws IOException
     */
    public abstract FileWriter openFile(String filePath) throws IOException;

    /**
     * Closes the file's array and writer
     *
     * @param writer The writer of the current file
     * @throws IOException
     */
    public abstract void closeFile(FileWriter writer) throws IOException;

    /**
     * Deletes a file of a given type and count
     *
     * @param filePath The path of the file to delete
     * @throws FileNotDeletedException
     */
    public void deleteFile(String filePath) throws FileNotDeletedException {
        File emptyFile = new File(filePath);
        if (!emptyFile.delete()) {
            throw new FileNotDeletedException(emptyFile.getName());
        }
    }
}
