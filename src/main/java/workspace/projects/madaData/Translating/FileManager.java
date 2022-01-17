package workspace.projects.madaData.Translating;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    /**
     * Creates a new Writer and opens ana array for the records
     *
     * @param filePath The path of the file to delete
     * @return Returns a new FileWriter
     * @throws IOException
     */
    protected FileWriter openFile(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.append("[\n");
        return writer;
    }

    /**
     * Closes the file's array and writer
     *
     * @param writer The writer of the current file
     * @throws IOException
     */
    protected void closeFile(FileWriter writer) throws IOException {
        writer.append("\n]");
        writer.close();
    }

    /**
     * Deletes a file of a given type and count
     *
     * @param filePath The path of the file to delete
     * @throws FileNotDeletedException
     */
    protected void deleteFile(String filePath) throws FileNotDeletedException {
        File emptyFile = new File(filePath);
        if (!emptyFile.delete()) {
            throw new FileNotDeletedException(emptyFile.getName());
        }
    }
}
