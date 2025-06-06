package eu.senla.client.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DBURL = eu.senla.core.ReadPropertiesFile.getProperty("DB_URL");
    private static final String USER = eu.senla.core.ReadPropertiesFile.getProperty("DB_USERNAME");
    private static final String PASSWORD = eu.senla.core.ReadPropertiesFile.getProperty("DB_PASSWORD");
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConnection.class);

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

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
