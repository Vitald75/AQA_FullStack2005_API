package eu.senla.client.adminRequest;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.adminRequest.AdminRequest;
import eu.senla.dto.adminRequest.PostAdminResponse;

public class SendAdminRequest {
    // @SneakyThrows
    public static final PostAdminResponse sendAdminRequest(AdminRequest request) {

        PostAdminResponse response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/sendAdminRequest",
                request,
                PostAdminResponse.class);

        return response;
    }
}
