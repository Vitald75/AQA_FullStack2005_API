package eu.senla.dto.requestProcess;

import com.fasterxml.jackson.annotation.JsonProperty;


public record RequestProcess(
        @JsonProperty("applId")
        Integer applicationId,
        @JsonProperty("staffid")
        Integer staffId,
        String action) {
}
