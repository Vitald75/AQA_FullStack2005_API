package eu.senla;

import eu.senla.client.adminRequest.SetupAdminRequestData;
import eu.senla.client.userRequest.SendUserRequest;
import eu.senla.client.userRequest.SetupUserRequestData;
import eu.senla.dto.adminRequest.AdminRequest;
import eu.senla.dto.adminRequest.PostAdminResponse;
import eu.senla.dto.userRequest.PostUserResponseBirth;
import eu.senla.dto.userRequest.UserRequest;
import org.postgresql.jdbc3.Jdbc3ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import static eu.senla.client.adminRequest.SendAdminRequest.sendAdminRequest;

public class DatabaseConnectionsTest {
    private static final String DBURL = eu.senla.core.ReadPropertiesFile.getProperty("DBURL");
    private static final String USER = eu.senla.core.ReadPropertiesFile.getProperty("DBUSERNAME");
    private static final String PASSWORD = eu.senla.core.ReadPropertiesFile.getProperty("DBPASSWORD");
    private static final Logger LOG = LoggerFactory.getLogger(Jdbc3ConnectionPool.class);

    private static Connection connection = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet resultSet = null;

    public static Connection connectToDB() {
        try {
            LOG.info("Trying to connect to DB ");
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Test(groups = {"database", "smoke"})
    public static void applicationPostedTest() {

        try {
            UserRequest request = SetupUserRequestData.createUserRequest("birth");
            SendUserRequest postRequest = new SendUserRequestTest();
            PostUserResponseBirth postResponse = postRequest.sendUserRequest(request, PostUserResponseBirth.class);

            int applicationId = postResponse.getData().getApplicationId();
            int applicantId = postResponse.getData().getApplicantId();
            String lastName = request.getPersonalLastName();
            String firstName = request.getPersonalFirstName();
            int applicationIdFromDB = 0;
            int applicantIdFromDB = 0;
            String lastNameFromDB = "";
            String firstNameFromDB = "";

            String selectSQL = "SELECT * FROM reg_office.applications a1 JOIN reg_office.applicants a2 ON a1.applicantid "
                   + "= a2.applicantid WHERE a1.applicationid = ? and a1.applicantid = ?";
            pstmt = connectToDB().prepareStatement(selectSQL);
            pstmt.setInt(1, applicationId);
            pstmt.setInt(2, applicantId);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "Appl ID: " + resultSet.getInt("applicationid")
                        + ", Type of appl: "  + resultSet.getString("kindofapplication")
                        + ", Status: " + resultSet.getString("statusofapplication"));

                applicationIdFromDB = resultSet.getInt("applicationid");
                applicantIdFromDB = resultSet.getInt("applicantid");
                lastNameFromDB = resultSet.getString("surname");
                firstNameFromDB = resultSet.getString("name");
            }

            SoftAssert softAssertApplication = new SoftAssert();

            softAssertApplication.assertEquals(applicationId, applicationIdFromDB);
            softAssertApplication.assertEquals(applicantIdFromDB, applicantId);
            softAssertApplication.assertEquals(lastNameFromDB, lastName);
            softAssertApplication.assertEquals(firstNameFromDB, firstName);

            softAssertApplication.assertAll("Application or applicants record doesn't match");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"database", "smoke"})
    public static void adminRequestPostedTest() {

        try {
            AdminRequest request = SetupAdminRequestData.createAdminRequestData();
            String lastName  = request.personalLastName();
            String passport = request.personalNumberOfPassport();

            PostAdminResponse response = sendAdminRequest(request);

            int staffId = response.getData().getStaffId();
            int staffIdFromDB = 0;
            String surnameFromDB = "";
            String passportNumberFromDB = "";

            String selectSQL = "SELECT * FROM reg_office.staff WHERE staffid = ?";
            pstmt = connectToDB().prepareStatement(selectSQL);
            pstmt.setInt(1, staffId);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "Staff ID: " + resultSet.getInt("staffid")
                        + ", Surname: " + resultSet.getString("surname")
                        + ", Passport: " + resultSet.getString("passportnumber"));

                staffIdFromDB = resultSet.getInt("staffid");
                surnameFromDB = resultSet.getString("surname");
                passportNumberFromDB = resultSet.getString("passportnumber");
            }

            Assert.assertEquals(staffId, staffIdFromDB);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(staffIdFromDB, staffId, "StaffId doesn't match");
            softAssert.assertEquals(surnameFromDB, lastName, "Lastname doesn't match");
            softAssert.assertEquals(passportNumberFromDB, passport, "Passport number doesn't match");
            softAssert.assertAll("Check for admin record in DB");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        }

}
