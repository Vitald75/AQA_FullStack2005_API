package eu.senla.dto.getApplStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GetApplStatusResponseData {
    @JsonProperty("dateofapplication")
    private String dateOfApplication;
    @JsonProperty("kindofapplication")
    private String kindOfApplication;
    @JsonProperty("statusofapplication")
    private String statusOfApplication;
}
