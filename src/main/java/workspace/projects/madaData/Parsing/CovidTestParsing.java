package workspace.projects.madaData.Parsing;

import org.apache.commons.csv.CSVRecord;
import workspace.projects.madaData.Entities.CovidTest;

import java.util.LinkedHashSet;

public interface CovidTestParsing {

    /**
     * Parses the data from the file to a LinkedHashSet of CovidTest instances
     * @param records The records from the file
     * @return Returns a LinkedHashSet of CovidTest instances built from the records
     */
    public abstract LinkedHashSet<CovidTest> parseCovidTest(Iterable<CSVRecord> records);
}
