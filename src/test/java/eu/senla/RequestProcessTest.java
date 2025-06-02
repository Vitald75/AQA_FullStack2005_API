package eu.senla;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.adminRequest.PostAdminResponse;
import eu.senla.dto.requestProcess.PostRequestProcessResponse;
import eu.senla.dto.requestProcess.RequestProcess;
import eu.senla.dto.userRequest.PostUserResponseWedding;
import eu.senla.dto.userRequest.SetupUserRequestData;
import eu.senla.dto.userRequest.UserRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestProcessTest {
    UserRequest request;

    @Test
    public void requestProcess() {

        //send
        request = SetupUserRequestData.createUserRequest("wedding");
        SendUserRequestTest postRequest = new SendUserRequestTest();
        PostUserResponseWedding postResponse = postRequest.sendUserRequest(request, PostUserResponseWedding.class);
        int applicationId = postResponse.getData().getApplicationId();


        AdminRequestTest adminRequest = new AdminRequestTest();
        PostAdminResponse adminResponse = adminRequest.sendAdminRequest();
        int staffId =adminResponse.getData().getStaffId();

        RequestProcess bodyRequestProcess = new RequestProcess(applicationId,staffId,"approved");

        PostRequestProcessResponse response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/requestProcess",
                bodyRequestProcess,
                PostRequestProcessResponse.class);

        Assert.assertNotNull(response.getRequestId());
        //Assert.assertEquals(response.getData().getKindOfApplication(),"Получение свидетельства о браке");
        Assert.assertEquals(response.getData().getStatusOfApplication(),"approved");
    }
}
