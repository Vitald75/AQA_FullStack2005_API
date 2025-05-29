package eu.senla;

import com.fasterxml.jackson.databind.json.JsonMapper;
import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.AdminRequest;
import eu.senla.dto.PostAdminResponse;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;

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

//        ObjectMapper mapper = new JsonMapper();
//        String jsonBody = mapper.writeValueAsString(request);
//        System.out.println("Request " + jsonBody);

    }

    @Test
    void sendAdminRequestTest() {

//        PostAdminResponse response = RequestManager.postRequest(
//                SpecConfig.requestSpecification(),
//                SpecConfig.responseSpecification(),
//                "/sendAdminRequest",
//                request,
//                PostAdminResponse.class);

        PostAdminResponse response =
                given()
                    .contentType(ContentType.JSON)
                    .body(request)  // Automatic JSON serialization
                .when()
                    .post(eu.senla.core.ReadPropertiesFile.getProperty("MAIN_URI") + "/sendAdminRequest")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().as(PostAdminResponse.class);



        //  System.out.println("Request " + request);

        //System.out.println(response);
        // System.out.println(response.getRequestId());
        // System.out.println(response.getData().getFirst().getStaffId());


        Assert.assertNotNull(response.getRequestId());

    }
}
