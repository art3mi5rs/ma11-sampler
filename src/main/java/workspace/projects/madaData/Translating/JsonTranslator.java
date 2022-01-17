package workspace.projects.madaData.Translating;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.projects.madaData.People.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class JsonTranslator extends DataTranslator {
    String type;

    public JsonTranslator(String fileBase, int maxRecords) {
        super(fileBase, new FileManager(), maxRecords);
        type = ".json";
    }

    @Override
    public void translate(HashSet<? extends Person> people) throws IOException, FileNotDeletedException {
        ObjectMapper objectMapper = new ObjectMapper();
        boolean isFirstLine = true;
        int recordCount = 0;
        int fileCount = 0;
        FileWriter writer = manager.openFile(fileBase + fileCount + type);

        for (Person person : people) {
            if (isFirstLine) {
                isFirstLine = false;
            } else {
                if (recordCount % maxRecords == 0 && recordCount != 0) {
                    manager.closeFile(writer);
                    fileCount++;
                    writer = manager.openFile(fileBase + fileCount + type);
                }
                writer.append(objectMapper.writeValueAsString(person));
                writer.append(", \n");
                recordCount++;
            }
        }

        if (recordCount % (maxRecords + 1) != 0) {
            manager.closeFile(writer);
        } else {
            manager.deleteFile(fileBase + fileCount + type);
        }
    }

}
