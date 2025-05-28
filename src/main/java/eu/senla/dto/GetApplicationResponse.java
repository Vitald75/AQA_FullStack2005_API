package eu.senla.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetApplicationResponse {

    @JsonProperty("total")
    private String total;
    @JsonProperty("data")
    private List<ApplicationData> data;
    @JsonProperty("requestId")
    private String requestId;

}