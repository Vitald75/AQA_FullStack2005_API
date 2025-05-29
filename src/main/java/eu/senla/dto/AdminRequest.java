package eu.senla.dto;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public record AdminRequest(
        String personalFirstName,
        String personalLastName,
        String personalMiddleName,
        String personalNumberOfPassport,
        String personalPhoneNumber,
        String dateOfBirth) {

}
