package workspace.projects.madaData.Parsing;

import org.apache.commons.csv.CSVRecord;
import workspace.projects.madaData.People.TestedPerson;

import java.util.HashSet;

public interface TestedPersonParsing {

    /**
     * Parses the data from the file to a HashSet of TestedPerson instances
     * @param records The records from the file
     * @return Returns a HashSet of TestedPerson instances built from the records
     */
    public abstract HashSet<TestedPerson> parseTestedPerson(Iterable<CSVRecord> records);

}
