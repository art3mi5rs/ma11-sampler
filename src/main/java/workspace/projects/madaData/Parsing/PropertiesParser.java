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

    public String getDataPath(){
        return props.getProperty("dataPath");
    }

    public String getTestedFileBase(){
        return props.getProperty("testedFileBase");
    }

    public int getMaxRecords(){
        return Integer.parseInt(props.getProperty("maxRecords"));
    }

}
