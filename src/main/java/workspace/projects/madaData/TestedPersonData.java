package workspace.projects.madaData;

import workspace.projects.madaData.Parsing.FileParser;
import workspace.projects.madaData.Parsing.PropertiesParser;
import workspace.projects.madaData.Entities.Entity;
import workspace.projects.madaData.Translating.DataTranslator;
import workspace.projects.madaData.Translating.FileNotDeletedException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

public class TestedPersonData extends MadaData {

    public TestedPersonData(FileParser parser, DataTranslator translator) {
        super(parser, translator);
    }

    @Override
    public void runProgram() throws IOException, FileNotDeletedException {
        PropertiesParser config = new PropertiesParser();
        LinkedHashSet<? extends Entity> entities = parser.parse(new File(config.getTestedDataPath()));
        translator.translate(entities);
    }
}
