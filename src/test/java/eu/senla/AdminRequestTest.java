package eu.senla;

import eu.senla.client.adminRequest.SendAdminRequest;
import eu.senla.client.adminRequest.SetupAdminRequestData;
import eu.senla.dto.adminRequest.AdminRequest;
import eu.senla.dto.adminRequest.PostAdminResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminRequestTest extends SendAdminRequest {

    AdminRequest request;

    @Test (groups = {"admin", "smoke"})
    void sendAdminRequestTest() {

        request = SetupAdminRequestData.createAdminRequestData();
        PostAdminResponse response = sendAdminRequest(request);

        Assert.assertNotNull(response.getRequestId());
    }
}
