package eu.senla;

import eu.senla.client.SelectFromDB;
import eu.senla.client.adminRequest.SendAdminRequest;
import eu.senla.client.adminRequest.SetupAdminRequestData;
import eu.senla.client.userRequest.SendUserRequest;
import eu.senla.client.userRequest.SetupUserRequestData;
import eu.senla.dto.dbResponse.AdminRequestDataFromDB;
import eu.senla.dto.dbResponse.UserRequestDataFromDB;
import eu.senla.dto.adminRequest.AdminRequest;
import eu.senla.dto.adminRequest.PostAdminResponse;
import eu.senla.dto.userRequest.PostUserResponseBirth;
import eu.senla.dto.userRequest.UserRequest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;

public class DatabaseConnectionsTest {

    @Test(groups = {"database", "smoke", "user"})
    public static void applicationPostedTest() throws SQLException {

        UserRequest request = SetupUserRequestData.createUserRequest("birth");
        SendUserRequest postRequest = new SendUserRequestTest();
        PostUserResponseBirth postResponse = postRequest.sendUserRequest(request, PostUserResponseBirth.class);

        int applicationId = postResponse.getData().getApplicationId();
        int applicantId = postResponse.getData().getApplicantId();

        String lastName = request.getPersonalLastName();
        String firstName = request.getPersonalFirstName();

        UserRequestDataFromDB userRequestDataFromDB = new SelectFromDB().selectForUserRequest(applicationId, applicantId);

        SoftAssert softAssertApplication = new SoftAssert();
        softAssertApplication.assertEquals(applicationId, userRequestDataFromDB.applicationId());
        softAssertApplication.assertEquals(applicantId, userRequestDataFromDB.applicantId());
        softAssertApplication.assertEquals(lastName, userRequestDataFromDB.lastName());
        softAssertApplication.assertEquals(firstName, userRequestDataFromDB.firstName());

        softAssertApplication.assertAll("Application or applicants record in DB doesn't match");
    }

    @Test(groups = {"database", "smoke", "admin"})
    public static void adminRequestPostedTest() throws  SQLException {

            AdminRequest request = SetupAdminRequestData.createAdminRequestData();
            String lastName  = request.personalLastName();
            String passport = request.personalNumberOfPassport();

            PostAdminResponse response = SendAdminRequest.sendAdminRequest(request);
            int staffId = response.getData().getStaffId();
            int staffIdFromDB = 0;

            AdminRequestDataFromDB adminRequestDataFromDB = new SelectFromDB().selectForAdminRequest(staffId);

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(staffId, adminRequestDataFromDB.staffId(), "StaffId doesn't match");
            softAssert.assertEquals(lastName, adminRequestDataFromDB.lastName(), "Lastname doesn't match");
            softAssert.assertEquals(passport, adminRequestDataFromDB.passport(), "Passport number doesn't match");
            softAssert.assertAll("Admin request doesn't match in DB");
       }
}
