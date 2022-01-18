package workspace.projects.madaData;

import workspace.projects.madaData.Parsing.FileParser;
import workspace.projects.madaData.Translating.DataTranslator;
import workspace.projects.madaData.Translating.FileNotDeletedException;

import java.io.IOException;

public class CovidTestData extends MadaData{

    public CovidTestData(FileParser parser, DataTranslator translator) {
        super(parser, translator);
    }

    @Override
    public void runProgram() throws IOException, FileNotDeletedException {
        //TODO: write method contents
    }
}
