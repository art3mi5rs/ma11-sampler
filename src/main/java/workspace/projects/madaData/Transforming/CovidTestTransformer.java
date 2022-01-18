package workspace.projects.madaData.Transforming;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;
import workspace.projects.madaData.Entities.CovidTest;
import workspace.projects.madaData.Entities.Entity;

import java.util.LinkedHashSet;

public class CovidTestTransformer extends DataTransformer {

    @Override
    public LinkedHashSet<? extends Entity> transform(LinkedHashSet<? extends Entity> entities) throws InvalidIdException {
        LinkedHashSet<CovidTest> covidTests = new LinkedHashSet<>();
        int i = 0;

        for (Entity test : entities) {
            CovidTest covidTest = (CovidTest) test;
            int idNum = covidTest.getIdNum();
            int idType = covidTest.getIdType();
            String firstName = covidTest.getFirstName();
            String lastName = covidTest.getLastName();
            String resultDate = covidTest.getResultDate();
            String birthDate = covidTest.getBirthDate();
            String labCode = covidTest.getLabCode();
            String stickerNumber = covidTest.getStickerNumber();
            int resultTestCorona = covidTest.getResultTestCorona();
            String variant = covidTest.getVariant();
            String testType = covidTest.getTestType();

            HealthCareInfoProvider infoProvider = new HealthCareInfoProvider();
            PersonInsured person = infoProvider.fetchInfo(idNum, idType);
            String joinDate = String.valueOf(person.getJoinDate());
            int healthCareID = person.getHealthCareId();
            String healthCareName = person.getHealthCareName();

            covidTests.add(new CovidTest(idNum, idType, firstName, lastName, resultDate, birthDate, labCode,
                    stickerNumber, resultTestCorona, variant, testType, joinDate, healthCareID, healthCareName));

            i++;
        }

        return covidTests;
    }
}
