package eu.senla;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.PostAdminResponse;
import eu.senla.dto.UserRequest;
import lombok.SneakyThrows;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SendUserRequestTest {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    UserRequest request;

    @BeforeTest
    public void setup() {

        Faker faker = new Faker();
        request = new UserRequest(
                "birth",
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                faker.number().digits(7),
                faker.number().digits(8),
                faker.address().streetAddress(),
                null,
                null,
                null,
                faker.number().digits(7),
                faker.date().birthday(0, 1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER),
                faker.planet().name(),
                faker.name().maleFirstName(),
                faker.name().femaleFirstName(),
                faker.name().maleFirstName(),
                faker.name().femaleFirstName(),
                null,
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                faker.date().birthday(18, 90).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER),
                faker.number().digits(7),
                faker.gender().types(),
                faker.address().streetAddress(),
                null,
                null,
                null
        );

        System.out.println("Request " + request);
    }

    @SneakyThrows
    @Test
    void sendUserRequestBirthTest() {
        PostAdminResponse response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/sendAdminRequest",
                request,
                PostAdminResponse.class);

        Assert.assertNotNull(response.getRequestId());

    }
}