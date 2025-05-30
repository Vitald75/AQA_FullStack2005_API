package eu.senla.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponseData {
    @JsonProperty("applicantid")
    private Integer applicantId;
    @JsonProperty("citizenid")
    private Integer citizenId;
    @JsonProperty("applicationid")
    private Integer applicationId;
    @JsonProperty("merrigecertificateid")
    private Integer merrigeCertificateId;

}
