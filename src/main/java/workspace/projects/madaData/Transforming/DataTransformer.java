package workspace.projects.madaData.Transforming;

import workspace.projects.madaData.Entities.Entity;

import java.util.LinkedHashSet;

public abstract class DataTransformer {

    /**
     * Transforms the data to fit the requirements
     * note: additional subclasses of Entity may need to be created to match data
     *
     * @param people An array of Entity instances
     * @return Returns a transformed array of Entity instances
     */
    public abstract LinkedHashSet<Entity> transform(LinkedHashSet<Entity> people);

}
