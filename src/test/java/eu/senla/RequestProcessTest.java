package eu.senla;

import eu.senla.client.*;
import eu.senla.client.adminRequest.SendAdminRequest;
import eu.senla.client.adminRequest.SetupAdminRequestData;
import eu.senla.client.userRequest.SendUserRequest;
import eu.senla.client.userRequest.SetupUserRequestData;
import eu.senla.dto.adminRequest.AdminRequest;
import eu.senla.dto.adminRequest.PostAdminResponse;
import eu.senla.dto.requestProcess.PostRequestProcessResponse;
import eu.senla.dto.requestProcess.RequestProcess;
import eu.senla.dto.userRequest.PostUserResponseWedding;
import eu.senla.dto.userRequest.UserRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestProcessTest {
    UserRequest requestUserBody;
    AdminRequest requestAdminBody;

    @Test (groups = {"admin", "smoke"})
    public void requestProcess() {

        //send User request
        requestUserBody = SetupUserRequestData.createUserRequest("wedding");
        SendUserRequest postRequest = new SendUserRequest();
        PostUserResponseWedding postResponse = postRequest.sendUserRequest(requestUserBody, PostUserResponseWedding.class);
        int applicationId = postResponse.getData().getApplicationId();

        //send Admin request
        requestAdminBody = SetupAdminRequestData.createAdminRequestData();
        SendAdminRequest adminRequest = new SendAdminRequest();
        PostAdminResponse adminResponse = adminRequest.sendAdminRequest(requestAdminBody);
        int staffId =adminResponse.getData().getStaffId();

        RequestProcess requestProcessBody = new RequestProcess(applicationId,staffId,"approved");

        PostRequestProcessResponse response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/requestProcess",
                requestProcessBody,
                PostRequestProcessResponse.class);

        Assert.assertNotNull(response.getRequestId());
        //Assert.assertEquals(response.getData().getKindOfApplication(),"Получение свидетельства о браке");
        Assert.assertEquals(response.getData().getStatusOfApplication(),"approved");
    }
}
