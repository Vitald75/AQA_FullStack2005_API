package eu.senla;

import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.dto.getApplStatus.GetApplicationsResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetApplicationsTest {

    @Test (groups = {"admin", "smoke"})
    public void getApplications() {
        GetApplicationsResponse response = RequestManager
                .getRequest(SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/getApplications",
                GetApplicationsResponse.class);

        Assert.assertNotNull(response.getTotal());
    }

    @Test (groups = {"database", "smoke"})
    public void dbTest() {

        String url = eu.senla.core.ReadPropertiesFile.getProperty("DBURL");
        String user = "user";
        String password = "user_senla";
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection connection
                    = DriverManager.getConnection(
                    url, user, password);
            System.out.println(
                    "Connected to PostgreSQL database!");

            // Create a statement
            Statement statement
                    = connection.createStatement();

            // Create a table if not exists
//            String selectTableSQL
//                    = "SELECT applicationid FROM reg_office.applications WHERE applicationid=42356";
//            statement.execute(selectTableSQL);


            // Retrieve data from the table
            String selectSQL = "SELECT * FROM reg_office.applications WHERE applicationid>49900";
            ResultSet resultSet
                    = statement.executeQuery(selectSQL);

            System.out.println("Select was executed!");

            while (resultSet.next()) {
                System.out.println(
                        "User ID: " + resultSet.getInt("applicationid")
                                + ", Name: "
                                + resultSet.getString("kindofapplication")
                                + ", Email: "
                                + resultSet.getString("statusofapplication"));
            }

            // Close the connection
            connection.close();
            System.out.println("Connection closed.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
