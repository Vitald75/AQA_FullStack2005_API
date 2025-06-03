package eu.senla;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public final class DatabaseTest {
    private static final String Dburl = eu.senla.core.ReadPropertiesFile.getProperty("DBURL");
    private static final String user = "user";
    private static final String password = "user_senla";
    private static final Logger log = LoggerFactory.getLogger(JdbcConnection.class);

    private static Connection con = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static Connection connectToDB() {
        log.info("Connect to DB " + Dburl + " by " + user);

        return con;
    }


}
