package eu.senla;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.GetApplicationResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass2 {

    @Test
    public void getApp() {
        GetApplicationResponse response = RequestManager.getRequest(SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/getApplications",
                GetApplicationResponse.class);

        Assert.assertNotNull(response.getTotal());
    }
}
