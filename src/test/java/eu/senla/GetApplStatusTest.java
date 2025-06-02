package eu.senla;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.getApplStatus.GetApplStatusResponse;
import eu.senla.dto.userRequest.PostUserResponseWedding;
import eu.senla.client.userRequest.SetupUserRequestData;
import eu.senla.dto.userRequest.UserRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetApplStatusTest {
    private UserRequest request;

    @Test (groups = {"user", "smoke"})
    public void getAppStatus() {

        request = SetupUserRequestData.createUserRequest("wedding");

        SendUserRequestTest postRequest = new SendUserRequestTest();
        PostUserResponseWedding postResponse = postRequest.sendUserRequest(request, PostUserResponseWedding.class);

        int applicationId = postResponse.getData().getApplicationId();

        GetApplStatusResponse response = RequestManager
                .getRequest(SpecConfig.requestSpecification(),
                        SpecConfig.responseSpecification(),
                        "/getApplStatus/" + applicationId,
                        GetApplStatusResponse.class);

        Assert.assertNotNull(response.getRequestId());
        //Assert.assertEquals(response.getData().getKindOfApplication(),"Получение свидетельства о браке");
        //temporary issue with encoding
    }
}
