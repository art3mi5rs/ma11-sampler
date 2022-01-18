package workspace.projects.madaData;

import workspace.projects.madaData.Parsing.FileParser;
import workspace.projects.madaData.Transforming.DataTransformer;
import workspace.projects.madaData.Translating.DataTranslator;
import workspace.projects.madaData.Translating.FileNotDeletedException;

import java.io.IOException;

public class CovidTestData extends MadaData{
    DataTransformer transformer;

    public CovidTestData(FileParser parser, DataTransformer transformer, DataTranslator translator) {
        super(parser, translator);
        this.transformer = transformer;
    }

    @Override
    public void runProgram() throws IOException, FileNotDeletedException {
        //TODO: write method contents
    }
}
