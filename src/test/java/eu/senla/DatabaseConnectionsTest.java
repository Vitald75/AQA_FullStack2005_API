package eu.senla;

import eu.senla.client.userRequest.SendUserRequest;
import eu.senla.client.userRequest.SetupUserRequestData;
import eu.senla.dto.userRequest.PostUserResponseBirth;
import eu.senla.dto.userRequest.UserRequest;
import org.postgresql.jdbc3.Jdbc3ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class DatabaseConnectionsTest {
    private static final String url = eu.senla.core.ReadPropertiesFile.getProperty("DBURL");
    private static final String user = eu.senla.core.ReadPropertiesFile.getProperty("DBUSERNAME");
    private static final String password = eu.senla.core.ReadPropertiesFile.getProperty("DBPASSWORD");
    private static final Logger log = LoggerFactory.getLogger(Jdbc3ConnectionPool.class);

    private static Connection connection = null;
    private static Statement stmt = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet resultSet = null;

    public static Connection connectToDB() {

        try {
            log.info("Trying to connect to DB ");
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL database!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Test(groups = {"database", "smoke"})
    public static void dbTest() {

        try {
            // Create a statement
            stmt = connectToDB().createStatement();
            // Retrieve data from the table
            String selectSQL = "SELECT * FROM reg_office.applications WHERE applicationid>49900";
            resultSet = stmt.executeQuery(selectSQL);
            System.out.println("Select was executed!");
            while (resultSet.next()) {
                System.out.println(
                        "User ID: " + resultSet.getInt("applicationid")
                                + ", Name: "
                                + resultSet.getString("kindofapplication")
                                + ", Email: "
                                + resultSet.getString("statusofapplication"));
            }

            selectSQL = "SELECT * FROM reg_office.applications WHERE applicationid = ?";

            UserRequest request = SetupUserRequestData.createUserRequest("birth");
            SendUserRequest postRequest = new SendUserRequestTest();
            PostUserResponseBirth postResponse = postRequest.sendUserRequest(request, PostUserResponseBirth.class);

            int applicationid = postResponse.getData().getApplicationId();
            int applicationidDB = 0;

            pstmt = connectToDB().prepareStatement(selectSQL);
            pstmt.setInt(1, applicationid);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "User ID: " + resultSet.getInt("applicationid")
                                + ", Name: "
                                + resultSet.getString("kindofapplication")
                                + ", Email: "
                                + resultSet.getString("statusofapplication"));
                applicationidDB = resultSet.getInt("applicationid");
            }

            Assert.assertEquals(applicationid, applicationidDB);

            // Close the connection
            connection.close();
            System.out.println("Connection closed.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
