package workspace.projects.madaData.Translating;

import workspace.projects.madaData.Entities.Entity;
import workspace.projects.madaData.Translating.Managers.JsonFileManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;

public class XMLTranslator extends DataTranslator{
    String type;

    public XMLTranslator(String fileBase, JsonFileManager manager, int maxRecords) {
        super(fileBase, manager, maxRecords);
        type = ".xml";
    }

    @Override
    public void translate(LinkedHashSet<? extends Entity> entities) throws IOException, FileNotDeletedException {
        int recordCount = 0;
        int fileCount = 0;
        FileWriter writer = manager.openFile(fileBase + fileCount + type);

        for (Entity entity : entities) {
            if (recordCount % maxRecords == 0 && recordCount != 0) {
                manager.closeFile(writer);
                fileCount++;
                writer = manager.openFile(fileBase + fileCount + type);
            }

            //add entity to file

            writer.append(", \n");
            recordCount++;
        }

        if (recordCount % (maxRecords + 1) != 0) {
            manager.closeFile(writer);
        } else {
            manager.deleteFile(fileBase + fileCount + type);
        }

    }
}
