package eu.senla.dto.adminRequest;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

import com.fasterxml.jackson.annotation.JsonProperty;

public record AdminRequest(
        String personalFirstName,
        String personalLastName,
        String personalMiddleName,
        String personalNumberOfPassport,
        String personalPhoneNumber,
        @JsonProperty("dateofbirth")
        String dateOfBirth) {

}
