package workspace.projects.madaData.Translating;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.projects.madaData.People.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class JsonTranslator extends DataTranslator {

    public JsonTranslator(String fileBase) {
        super(fileBase);
    }

    @Override
    public void translate(HashSet<? extends Person> people) throws IOException, FileNotDeletedException {
        ObjectMapper objectMapper = new ObjectMapper();
        boolean isFirstLine = true;
        int recordCount = 0;
        int fileCount = 0;
        FileWriter writer = openFile(fileCount);

        for (Person person : people) {
            if (isFirstLine) {
                isFirstLine = false;
            } else {
                if (recordCount % 50000 == 0 && recordCount != 0) {
                    closeFile(writer);
                    fileCount++;
                    writer = openFile(fileCount);
                }
                objectMapper.writeValue(writer, person); //does this append or write
                recordCount++;
            }
        }

        if (recordCount % 50001 != 0) {
            closeFile(writer);
        } else {
            File emptyFile = new File(fileBase + fileCount + ".json");
            if (!emptyFile.delete()) {
                throw new FileNotDeletedException(emptyFile.getName());
            }
        }
    }

    /**
     * Creates a new Writer and opens ana array for the records
     *
     * @param fileNum The number of previous files written
     * @return Returns a new FileWriter
     * @throws IOException
     */
    private FileWriter openFile(int fileNum) throws IOException {
        FileWriter writer = new FileWriter(fileBase + fileNum + ".json");
        writer.append("[\n");
        return writer;
    }

    /**
     * Closes the file's array and writer
     *
     * @param writer The writer of the current file
     * @throws IOException
     */
    private void closeFile(FileWriter writer) throws IOException {
        writer.append("\n]");
        writer.close();
    }

}
