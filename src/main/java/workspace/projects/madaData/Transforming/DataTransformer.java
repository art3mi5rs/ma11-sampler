package workspace.projects.madaData.Transforming;

import workspace.projects.madaData.Entities.CovidTest;
import workspace.projects.madaData.Entities.Entity;

import java.util.LinkedHashSet;

public abstract class DataTransformer {

    /**
     * Transforms the data to fit the requirements
     * note: additional subclasses of Entity may need to be created to match data
     *
     * @param entities An array of Entity subclass instances
     * @return Returns a transformed array of Entity instances
     */
    public abstract LinkedHashSet<? extends Entity> transform(LinkedHashSet<? extends Entity> entities) throws Exception;

}
