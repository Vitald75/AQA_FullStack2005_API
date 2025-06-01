package eu.senla.dto.requestProcess;

import eu.senla.dto.adminRequest.AdminResponseData;
import lombok.Getter;

@Getter
public class PostRequestProcessResponse {
    private PostRequestProcessResponseData data;
    private String requestId;
}
