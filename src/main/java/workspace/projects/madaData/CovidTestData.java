package workspace.projects.madaData;

import health_care_provider.errors.InvalidIdException;
import workspace.projects.madaData.Entities.Entity;
import workspace.projects.madaData.Parsing.FileParser;
import workspace.projects.madaData.Parsing.PropertiesParser;
import workspace.projects.madaData.Transforming.DataTransformer;
import workspace.projects.madaData.Translating.DataTranslator;
import workspace.projects.madaData.Translating.FileNotDeletedException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

public class CovidTestData extends MadaData {
    DataTransformer transformer;

    public CovidTestData(FileParser parser, DataTransformer transformer, DataTranslator translator) {
        super(parser, translator);
        this.transformer = transformer;
    }

    @Override
    public void runProgram() throws IOException, FileNotDeletedException {
        PropertiesParser config = new PropertiesParser();
        LinkedHashSet<? extends Entity> tests = parser.parse(new File(config.getCovidTestDataPath()));
        try {
            transformer.transform(tests);
        } catch (InvalidIdException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        translator.translate(tests);
    }
}
