package workspace.projects.madaData.Parsing;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import workspace.projects.madaData.Entities.CovidTest;
import workspace.projects.madaData.Entities.Entity;
import workspace.projects.madaData.Entities.TestedPerson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashSet;

public class CsvParser extends FileParser implements TestedPersonParsing, CovidTestParsing {
    //TODO: Figure out how to deal with multiple data files

    @Override
    public LinkedHashSet<? extends Entity> parse(File file) throws IOException {
        Reader in = new FileReader(file.getPath());
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);

        LinkedHashSet<? extends Entity> entities = parseTestedPerson(records);

        return entities;
    }

    @Override
    public LinkedHashSet<TestedPerson> parseTestedPerson(Iterable<CSVRecord> records) {
        LinkedHashSet<TestedPerson> testedPeople = new LinkedHashSet<>();
        boolean firstIteration = true;

        for (CSVRecord record : records) {
            if (!firstIteration) {
                String mdaCode = record.get(0);
                int idNum = Integer.parseInt(record.get(1));
                int idType = Integer.parseInt(record.get(2));
                String firstName = record.get(3);
                String lastName = record.get(4);
                String city = record.get(5);
                String street = record.get(6);
                int buildingNumber = Integer.parseInt(record.get(7));
                String barcode = record.get(8);
                String getDate = record.get(9);
                String takeDate = record.get(10);
                String resultDate = record.get(11);

                testedPeople.add(new TestedPerson(mdaCode, idNum, idType, firstName, lastName, city, street, buildingNumber,
                        barcode, getDate, takeDate, resultDate));
            } else {
                firstIteration = false;
            }
        }
        return testedPeople;
    }

    @Override
    public LinkedHashSet<CovidTest> parseCovidTest(Iterable<CSVRecord> records) {
        LinkedHashSet<CovidTest> covidTests = new LinkedHashSet<>();
        boolean firstIteration = true;

        for (CSVRecord record : records) {
            if (!firstIteration) {
                int idNum = Integer.parseInt(record.get(0));
                int idType = Integer.parseInt(record.get(1));
                String firstName = record.get(2);
                String lastName = record.get(3);
                String resultDate = record.get(4);
                String birthDate = record.get(5);
                String labCode = record.get(6);
                String stickerNumber = record.get(7);
                int resultTestCorona = Integer.parseInt(record.get(8));
                String variant = record.get(9);
                String testType = record.get(10);

                covidTests.add(new CovidTest(idNum, idType, firstName, lastName, resultDate, birthDate, labCode,
                        stickerNumber, resultTestCorona, variant, testType));

            } else {
                firstIteration = false;
            }
        }

        return covidTests;
    }
}
