package workspace.projects.madaData.Parsing;

import org.apache.commons.csv.CSVRecord;
import workspace.projects.madaData.Entities.TestedPerson;

import java.util.LinkedHashSet;

public interface TestedPersonParsing {

    /**
     * Parses the data from the file to a LinkedHashSet of TestedPerson instances
     * @param records The records from the file
     * @return Returns a LinkedHashSet of TestedPerson instances built from the records
     */
    public abstract LinkedHashSet<TestedPerson> parseTestedPerson(Iterable<CSVRecord> records);

}
