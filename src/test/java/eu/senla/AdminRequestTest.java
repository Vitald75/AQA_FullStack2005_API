package eu.senla;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.AdminRequest;
import eu.senla.dto.PostAdminResponse;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AdminRequestTest {

    AdminRequest request;

    @BeforeTest
    public void setup() {
        Faker faker = new Faker();
        request = new AdminRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.funnyName().name(),
                faker.number().digits(9),
                faker.number().digits(8),
                LocalDate.now().toString()
        );
        System.out.println("Request " + request);
    }

    @Test
    void sendAdminRequestTest() {
        PostAdminResponse response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/sendAdminRequest",
                request,
                PostAdminResponse.class);
        //  System.out.println("Request " + request);

        //System.out.println(response);
        // System.out.println(response.getRequestId());
        // System.out.println(response.getData().getFirst().getStaffId());


        Assert.assertNotNull(response.getRequestId());

    }
}
