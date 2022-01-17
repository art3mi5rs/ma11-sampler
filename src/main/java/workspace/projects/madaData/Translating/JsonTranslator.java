package workspace.projects.madaData.Translating;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.projects.madaData.Entities.Entity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;

public class JsonTranslator extends DataTranslator {
    String type;

    public JsonTranslator(String fileBase, int maxRecords) {
        super(fileBase, new FileManager(), maxRecords);
        type = ".json";
    }

    @Override
    public void translate(LinkedHashSet<? extends Entity> entities) throws IOException, FileNotDeletedException {
        ObjectMapper objectMapper = new ObjectMapper();
        int recordCount = 0;
        int fileCount = 0;
        FileWriter writer = manager.openFile(fileBase + fileCount + type);

        for (Entity entity : entities) {
            if (recordCount % maxRecords == 0 && recordCount != 0) {
                manager.closeFile(writer);
                fileCount++;
                writer = manager.openFile(fileBase + fileCount + type);
            }
            writer.append(objectMapper.writeValueAsString(entity));
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
