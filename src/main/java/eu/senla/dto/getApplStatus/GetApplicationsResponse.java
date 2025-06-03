package eu.senla.dto.getApplStatus;

import eu.senla.dto.ApplicationsData;
import lombok.Getter;

import java.util.List;

@Getter
//@JsonIgnoreProperties(ignoreUnknown = true)
public class GetApplicationsResponse {
    private String total;
    private List<ApplicationsData> data;
    private String requestId;

}
