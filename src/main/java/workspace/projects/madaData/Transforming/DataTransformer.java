package workspace.projects.madaData.Transforming;

import workspace.projects.madaData.People.Person;

import java.util.LinkedHashSet;

public abstract class DataTransformer {

    /**
     * Transforms the data to fit the requirements
     * note: additional subclasses of Person may need to be created to match data
     *
     * @param people An array of Person instances
     * @return Returns a transformed array of Person instances
     */
    public abstract LinkedHashSet<Person> transform(LinkedHashSet<Person> people);

}
