package workspace.projects.madaData;

import workspace.projects.madaData.Parsing.FileParser;
import workspace.projects.madaData.Transforming.DataTransformer;
import workspace.projects.madaData.Translating.DataTranslator;
import workspace.projects.madaData.Translating.FileNotDeletedException;

import java.io.IOException;

public abstract class MadaData {
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
    public abstract void runProgram() throws IOException, FileNotDeletedException ;
}
