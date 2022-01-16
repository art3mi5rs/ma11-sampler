package workspace.projects.madaData.Parsing;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesParser {
    Properties props;

    public PropertiesParser(){
        init();
    }

    public void init(){
        try {
            InputStream stream = getClass().getResourceAsStream("database_props.properties");
            props = new Properties();
            props.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
