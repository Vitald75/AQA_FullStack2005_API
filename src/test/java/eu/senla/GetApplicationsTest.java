package eu.senla;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.getApplStatus.GetApplicationsResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetApplicationsTest {

    @Test (groups = {"admin", "smoke"})
    public void getApplications() {
        GetApplicationsResponse response = RequestManager
                .getRequest(SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/getApplications",
                GetApplicationsResponse.class);

        Assert.assertNotNull(response.getTotal());
    }
}
