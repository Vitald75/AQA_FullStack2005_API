package eu.senla;

import com.sun.net.httpserver.Request;
import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.userRequest.PostUserResponseBirth;
import eu.senla.dto.userRequest.PostUserResponseDeath;
import eu.senla.dto.userRequest.PostUserResponseWedding;
import eu.senla.dto.userRequest.SetupUserRequestData;
import eu.senla.dto.userRequest.UserRequest;
import lombok.SneakyThrows;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.format.DateTimeFormatter;

public class SendUserRequestTest {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    UserRequest request;

    @SneakyThrows
    @Test
    void sendUserRequestBirthTest() {
        request = SetupUserRequestData.createUserRequest("birth");

        SendUserRequestTest postRequest = new SendUserRequestTest();
        PostUserResponseBirth postResponse = postRequest.sendUserRequest(request, PostUserResponseBirth.class);
        Assert.assertNotNull(postResponse.getRequestId());

    }

    @SneakyThrows
    @Test
    void sendUserRequestWeddingTest() {
        request = SetupUserRequestData.createUserRequest("wedding");

        SendUserRequestTest postRequest = new SendUserRequestTest();
        PostUserResponseWedding postResponse = postRequest.sendUserRequest(request, PostUserResponseWedding.class);
        Assert.assertNotNull(postResponse.getRequestId());
    }

    @SneakyThrows
    @Test
    void sendUserRequestDeathTest() {

        request = SetupUserRequestData.createUserRequest("death");
        SendUserRequestTest postRequest = new SendUserRequestTest();
        PostUserResponseDeath postResponse = postRequest.sendUserRequest(request, PostUserResponseDeath.class);
        Assert.assertNotNull(postResponse.getRequestId());
    }

    @SneakyThrows
    public <T> T sendUserRequest(UserRequest request, Class<T> clazz) {

        //request.setMode("death");
        T response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/sendUserRequest",
                request,
                clazz);
        return response;

    }


}