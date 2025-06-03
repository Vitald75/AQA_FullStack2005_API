package eu.senla.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationsData {

    @JsonProperty("applicantid")
    private Integer applicantId;
    @JsonProperty("applicationid")
    private Integer applicationId;
    private String channel;
    @JsonProperty("citizenid")
    private Integer citizenId;
    @JsonProperty("dateOfApplication")
    private String dateofapplication;
    private String image;
    @JsonProperty("kindOfApplication")
    private String kindofapplication;
    @JsonProperty("staffId")
    private Integer staffid;
    @JsonProperty("statusOfApplication")
    private String statusofapplication;
}
