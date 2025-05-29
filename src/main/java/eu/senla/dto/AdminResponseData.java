package eu.senla.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AdminResponseData {

    @JsonProperty("staffid")
    private Integer staffId;

}
