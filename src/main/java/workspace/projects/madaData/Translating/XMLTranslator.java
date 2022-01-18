package workspace.projects.madaData.Translating;

import workspace.projects.madaData.Entities.Entity;
import workspace.projects.madaData.Translating.Managers.JsonFileManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
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

            try {
                JAXBContext context = JAXBContext.newInstance(Entity.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                StringWriter stringWriter = new StringWriter();
                marshaller.marshal(entity, stringWriter);
                writer.append(stringWriter.toString());
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            writer.append("\n");
            recordCount++;
        }

        if (recordCount % (maxRecords + 1) != 0) {
            manager.closeFile(writer);
        } else {
            manager.deleteFile(fileBase + fileCount + type);
        }

    }
}
