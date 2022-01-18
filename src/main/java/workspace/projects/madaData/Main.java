package workspace.projects.madaData;

import workspace.projects.madaData.Parsing.CsvParser;
import workspace.projects.madaData.Parsing.PropertiesParser;
import workspace.projects.madaData.Transforming.CovidTestTransformer;
import workspace.projects.madaData.Transforming.DataTransformer;
import workspace.projects.madaData.Translating.DataTranslator;
import workspace.projects.madaData.Translating.FileNotDeletedException;
import workspace.projects.madaData.Translating.JsonTranslator;
import workspace.projects.madaData.Translating.XMLTranslator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        try {
            CsvParser parser = new CsvParser();
            PropertiesParser config = new PropertiesParser();

            //Part 1
//            DataTranslator translator = new JsonTranslator(config.getTestedFileBase(), config.getMaxRecords());
//            DataTransformer transformer = null;
//            MadaData data = new TestedPersonData(parser, translator);

            //Part 2
            DataTranslator translator = new XMLTranslator(config.getCovidTestFileBase(), config.getMaxRecords());
            DataTransformer transformer = new CovidTestTransformer();
            MadaData data = new CovidTestData(parser, transformer, translator);

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
