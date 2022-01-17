package workspace.projects.madaData.Parsing;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesParser {
    Properties props;

    public PropertiesParser() throws IOException {
        init();
    }

    public void init() throws IOException {
        FileReader reader = new FileReader("src/main/resources/config.properties");
        props = new Properties();
        props.load(reader);
        reader.close();

    }

    /**
     * Gets the dataPath variable from the properties file
     *
     * @return returns the value of dataPath
     */
    public String getDataPath() {
        return props.getProperty("dataPath");
    }

    /**
     * Gets the testedFileBase variable from the properties file
     *
     * @return returns the value of testedFileBase
     */
    public String getTestedFileBase() {
        return props.getProperty("testedFileBase");
    }

    /**
     * Gets the maxRecords variable from the properties file
     *
     * @return returns the value of maxRecords
     */
    public int getMaxRecords() {
        return Integer.parseInt(props.getProperty("maxRecords"));
    }

}
