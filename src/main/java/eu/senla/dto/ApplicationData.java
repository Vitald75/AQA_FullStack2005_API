package eu.senla.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationData {

    private Integer applicantid;
    @JsonProperty("applicationid")
    private Integer applicationId;
    private String channel;
    private Integer citizenid;
    private String dateofapplication;
    private String image;
    private String kindofapplication;
    private Integer staffid;
    private String statusofapplication;
}
