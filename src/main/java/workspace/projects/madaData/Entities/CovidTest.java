package workspace.projects.madaData.Entities;

public class CovidTest extends Entity {
    private int idNum;
    private int idType;
    private String firstName;
    private String lastName;
    private String resultDate;
    private String birthDate;
    private String labCode;
    private String stickerNumber;
    private int resultTestCorona;
    private String variant;
    private String testType;
    private String joinDate;
    private int healthCareID;
    private String healthCareName;


    public CovidTest(int idNum, int idType, String firstName, String lastName, String resultDate, String birthDate,
                     String labCode, String stickerNumber, int resultTestCorona, String variant, String testType) {
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resultDate = resultDate;
        this.birthDate = birthDate;
        this.labCode = labCode;
        this.stickerNumber = stickerNumber;
        this.resultTestCorona = resultTestCorona;
        this.variant = variant;
        this.testType = testType;
    }

    public CovidTest(int idNum, int idType, String firstName, String lastName, String resultDate, String birthDate,
                     String labCode, String stickerNumber, int resultTestCorona, String variant, String testType,
                     String joinDate, int healthCareID, String healthCareName) {
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resultDate = resultDate;
        this.birthDate = birthDate;
        this.labCode = labCode;
        this.stickerNumber = stickerNumber;
        this.resultTestCorona = resultTestCorona;
        this.variant = variant;
        this.testType = testType;
        this.joinDate = joinDate;
        this.healthCareID = healthCareID;
        this.healthCareName = healthCareName;
    }


    public int getIdNum() {
        return idNum;
    }

    public int getIdType() {
        return idType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getResultDate() {
        return resultDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getLabCode() {
        return labCode;
    }

    public String getStickerNumber() {
        return stickerNumber;
    }

    public int getResultTestCorona() {
        return resultTestCorona;
    }

    public String getVariant() {
        return variant;
    }

    public String getTestType() {
        return testType;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public int getHealthCareID() {
        return healthCareID;
    }

    public String getHealthCareName() {
        return healthCareName;
    }

}
