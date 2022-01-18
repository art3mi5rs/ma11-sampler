package workspace.projects.madaData.Translating.Managers;

import java.io.FileWriter;
import java.io.IOException;

public class XMLFileManager extends FileManager {

    @Override
    public FileWriter openFile(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.append("<labTests>");
        return writer;
    }

    @Override
    public void closeFile(FileWriter writer) throws IOException {
        writer.append("</labTests>");
        writer.flush();
    }

}
