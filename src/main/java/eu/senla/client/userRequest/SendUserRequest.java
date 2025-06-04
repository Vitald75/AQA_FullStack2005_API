package eu.senla.client.userRequest;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.userRequest.UserRequest;
import lombok.SneakyThrows;

public class SendUserRequest {

    @SneakyThrows
    public final <T> T sendUserRequest(UserRequest request, Class<T> clazz) {
        T response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/sendUserRequest",
                request,
                clazz);
        return response;
    }

}
