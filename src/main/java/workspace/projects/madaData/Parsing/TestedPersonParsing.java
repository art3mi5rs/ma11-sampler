package workspace.projects.madaData.Parsing;

import org.apache.commons.csv.CSVRecord;
import workspace.projects.madaData.People.TestedPerson;

import java.util.HashSet;

public interface TestedPersonParsing {

    public abstract HashSet<TestedPerson> parseTestedPerson(Iterable<CSVRecord> records);

}
