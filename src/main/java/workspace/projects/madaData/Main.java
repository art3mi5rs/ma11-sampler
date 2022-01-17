package workspace.projects.madaData;

import workspace.projects.madaData.Parsing.CsvParser;
import workspace.projects.madaData.Translating.FileNotDeletedException;
import workspace.projects.madaData.Translating.JsonTranslator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        CsvParser parser = new CsvParser();
        JsonTranslator translator = new JsonTranslator("/Users/shachaf/MadaData/TestedPeopleData",
                50000); //DEBUG: Take from properties file
        MadaData data = new MadaData(parser, translator);

        try {
            data.runProgram();
        } catch (FileNotDeletedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
