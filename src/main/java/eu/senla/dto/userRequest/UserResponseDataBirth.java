package eu.senla.dto.userRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserResponseDataBirth {
    @JsonProperty("applicantid")
    private Integer applicantId;
    @JsonProperty("citizenid")
    private Integer citizenId;
    @JsonProperty("applicationid")
    private Integer applicationId;
    @JsonProperty("birthcertificateid")
    private Integer birthCertificateId;
}
