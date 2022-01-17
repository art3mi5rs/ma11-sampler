package workspace.projects.madaData;

import workspace.projects.madaData.Parsing.FileParser;
import workspace.projects.madaData.Parsing.PropertiesParser;
import workspace.projects.madaData.People.Person;
import workspace.projects.madaData.Transforming.DataTransformer;
import workspace.projects.madaData.Translating.DataTranslator;
import workspace.projects.madaData.Translating.FileNotDeletedException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

public class MadaData {
    FileParser parser;
    DataTransformer transformer;
    DataTranslator translator;

    //Allows for data transformation
    public MadaData(FileParser parser, DataTransformer transformer, DataTranslator translator) {
        this.parser = parser;
        this.transformer = transformer;
        this.translator = translator;
    }

    public MadaData(FileParser parser, DataTranslator translator) {
        this.parser = parser;
        this.translator = translator;
    }

    /**
     * Runs the program and extracts/transforms the data as needed
     *
     * @throws IOException
     * @throws FileNotDeletedException
     */
    public void runProgram() throws IOException, FileNotDeletedException {
        PropertiesParser config = new PropertiesParser();
        LinkedHashSet<? extends Person> people = parser.parse(new File(config.getDataPath()));
        translator.translate(people);
    }
}
