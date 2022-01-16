package workspace.projects.madaData.Translating;

import workspace.projects.madaData.People.Person;

import java.util.HashSet;

public abstract class DataTranslator {

    /**
     * Moves the data from the HashSet to File(s)
     *
     * @param people The HashSet of Person instances
     */
    public abstract void translate(HashSet<? extends Person> people);

}
