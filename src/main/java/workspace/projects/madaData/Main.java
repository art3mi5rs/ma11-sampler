package workspace.projects.madaData;

import workspace.projects.madaData.Parsing.CsvParser;
import workspace.projects.madaData.Parsing.PropertiesParser;
import workspace.projects.madaData.Translating.FileNotDeletedException;
import workspace.projects.madaData.Translating.JsonTranslator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        try {
            CsvParser parser = new CsvParser();
            PropertiesParser config = new PropertiesParser();
            JsonTranslator translator = new JsonTranslator(config.getTestedFileBase(), config.getMaxRecords());
            MadaData data = new TestedPersonData(parser, translator);

            data.runProgram();
        } catch (FileNotDeletedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
