package eu.senla;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.adminRequest.AdminRequest;
import eu.senla.dto.adminRequest.PostAdminResponse;
import lombok.SneakyThrows;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AdminRequestTest {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    AdminRequest request;

    //@BeforeTest
    public void setup() {
        Faker faker = new Faker();
        request = new AdminRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                faker.number().digits(7),
                faker.number().digits(8),
                faker.date().birthday(18, 99).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER)
                //LocalDate.now().toString()
                //"2020-01-01"
        );
        //System.out.println("Request " + request);

    }

    @SneakyThrows
    PostAdminResponse sendAdminRequest() {
        setup();
        PostAdminResponse response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/sendAdminRequest",
                request,
                PostAdminResponse.class);

        return response;
    }

    @SneakyThrows
    @Test
    void sendAdminRequestTest() {

        PostAdminResponse response = sendAdminRequest();
        Assert.assertNotNull(response.getRequestId());
    }
}
