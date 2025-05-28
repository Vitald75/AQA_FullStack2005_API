package eu.senla.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public record AdminRequest(
        @JsonProperty("personalLastName")
        String personalLastName,
        @JsonProperty("personalFirstName")
        String personalFirstName,
        @JsonProperty("personalMiddleName")
        String personalMiddleName,
        @JsonProperty("personalPhoneNumber")
        String personalPhoneNumber,
        @JsonProperty("personalNumberOfPassport")
        String personalNumberOfPassport,
        @JsonProperty("dateofbirth")
        String dateOfBirth) {

}
