package workspace.projects.madaData.Translating.Managers;

import workspace.projects.madaData.Translating.FileNotDeletedException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileManager extends FileManager {

    @Override
    public FileWriter openFile(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.append("[\n");
        return writer;
    }

    @Override
    public void closeFile(FileWriter writer) throws IOException {
        writer.append("]");
        writer.flush();
    }

    @Override
    public void deleteFile(String filePath) throws FileNotDeletedException {
        File emptyFile = new File(filePath);
        if (!emptyFile.delete()) {
            throw new FileNotDeletedException(emptyFile.getName());
        }
    }
}
