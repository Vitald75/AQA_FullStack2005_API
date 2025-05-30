package eu.senla;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.AdminRequest;
import eu.senla.dto.PostAdminResponse;
import lombok.SneakyThrows;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AdminRequestTest {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    AdminRequest request;

    @BeforeTest
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
        System.out.println("Request " + request);

//        ObjectMapper mapper = new JsonMapper();
//        String jsonBody = mapper.writeValueAsString(request);
//        System.out.println("Request " + jsonBody);

    }

    @SneakyThrows
    @Test
    void sendAdminRequestTest() {

        PostAdminResponse response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/sendAdminRequest",
                request,
                PostAdminResponse.class);

//        PostAdminResponse response =
//                given()
//                    .auth()
//                    .basic(eu.senla.core.ReadPropertiesFile.getProperty("USERNAME"),
//                                eu.senla.core.ReadPropertiesFile.getProperty("PASSWORD"))
//                    .contentType(ContentType.JSON)
//                    .body(request)// Automatic JSON serialization
//                        .log().all()
//                .when()
//                    .post(eu.senla.core.ReadPropertiesFile.getProperty("MAIN_URI") + "/sendAdminRequest")
//                .then()
//                        .log().all()
//                        .statusCode(200)
//                .contentType(ContentType.JSON)
//                .extract().as(PostAdminResponse.class);



      //  System.out.println("Request " + request);

        //System.out.println(response);
        // System.out.println(response.getRequestId());
        // System.out.println(response.getData().getFirst().getStaffId());


        Assert.assertNotNull(response.getRequestId());

    }
}
