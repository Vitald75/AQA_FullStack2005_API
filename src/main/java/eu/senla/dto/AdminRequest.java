package eu.senla.dto;

import lombok.Data;

@Data
public class AdminRequest {
    private String personalFirstName;
    private String personalLastName;
    private String personalMiddleName;
    private String personalNumberOfPassport;
    private String personalPhoneNumber;
    private String dateOfBirth;

    public AdminRequest(String personalFirstName, String personalLastName, String personalMiddleName, String personalNumberOfPassport, String personalPhoneNumber, String dateOfBirth) {
        this.personalFirstName = personalFirstName;
        this.personalLastName = personalLastName;
        this.personalMiddleName = personalMiddleName;
        this.personalNumberOfPassport = personalNumberOfPassport;
        this.personalPhoneNumber = personalPhoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

}
