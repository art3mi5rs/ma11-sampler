package workspace.projects.madaData.Parsing;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import workspace.projects.madaData.People.Person;
import workspace.projects.madaData.People.TestedPerson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashSet;

public class CsvParser extends FileParser implements TestedPersonParsing {

    @Override
    public LinkedHashSet<? extends Person> parse(File file) throws IOException {
        Reader in = new FileReader(file.getPath());
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);

        LinkedHashSet<? extends Person> people = parseTestedPerson(records);

        return people;
    }

    @Override
    public LinkedHashSet<TestedPerson> parseTestedPerson(Iterable<CSVRecord> records) {
        LinkedHashSet<TestedPerson> people = new LinkedHashSet<>();
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

                people.add(new TestedPerson(mdaCode, idNum, idType, firstName, lastName, city, street, buildingNumber,
                        barcode, getDate, takeDate, resultDate));
            } else {
                firstIteration = false;
            }
        }
        return people;
    }
}
