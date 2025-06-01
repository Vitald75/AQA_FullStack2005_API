package eu.senla.dto.requestProcess;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostRequestProcessResponseData {
    @JsonProperty("applicantid")
    private Integer applicantId;
    @JsonProperty("applicationid")
    private Integer applicationId;
    @JsonProperty("citizenid")
    private Integer citizenId;
    @JsonProperty("dateofapplication")
    private String dateOfApplication;
    @JsonProperty("kindofapplication")
    private String kindOfApplication;
    @JsonProperty("statusofapplication")
    private String statusOfApplication;
    @JsonProperty("staffid")
    private Integer staffid;
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("image")
    private String image;

}
