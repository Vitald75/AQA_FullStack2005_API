package eu.senla;

import eu.senla.client.userRequest.SendUserRequest;
import eu.senla.client.userRequest.SetupUserRequestData;
import eu.senla.dto.userRequest.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendUserRequestTest extends SendUserRequest {
    UserRequest request;

    @Test (groups = {"user", "smoke"})
    void sendUserRequestBirthTest() {
        request = SetupUserRequestData.createUserRequest("birth");

        SendUserRequest postRequest = new SendUserRequestTest();
        PostUserResponseBirth postResponse = postRequest.sendUserRequest(request, PostUserResponseBirth.class);

        Assert.assertNotNull(postResponse.getRequestId());
    }

    @Test (groups = {"user", "smoke"})
    void sendUserRequestWeddingTest() {
        request = SetupUserRequestData.createUserRequest("wedding");

        SendUserRequest postRequest = new SendUserRequestTest();
        PostUserResponseWedding postResponse = postRequest.sendUserRequest(request, PostUserResponseWedding.class);

        Assert.assertNotNull(postResponse.getRequestId());
    }

    @Test (groups = {"user", "smoke"})
    void sendUserRequestDeathTest() {

        request = SetupUserRequestData.createUserRequest("death");
        SendUserRequest postRequest = new SendUserRequestTest();
        PostUserResponseDeath postResponse = postRequest.sendUserRequest(request, PostUserResponseDeath.class);

        Assert.assertNotNull(postResponse.getRequestId());
    }

}