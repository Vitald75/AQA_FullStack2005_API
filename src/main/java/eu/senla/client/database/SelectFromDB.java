package eu.senla.client.database;

import eu.senla.dto.dbResponse.AdminRequestDataFromDB;
import eu.senla.dto.dbResponse.UserRequestDataFromDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectFromDB {

    public final UserRequestDataFromDB selectForUserRequest(int applicationId, int applicantId) throws SQLException {
        int applicationIdFromDB = 0;
        int applicantIdFromDB = 0;
        String lastNameFromDB = "";
        String firstNameFromDB = "";

        PreparedStatement pstmt;
        ResultSet resultSet;

        String selectSQL = "SELECT * FROM reg_office.applications a1 JOIN reg_office.applicants a2 ON a1.applicantid "
                + "= a2.applicantid WHERE a1.applicationid = ? and a1.applicantid = ?";
        pstmt = DatabaseConnection.connectToDB().prepareStatement(selectSQL);

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

        DatabaseConnection.closeConnection();

       return new UserRequestDataFromDB(applicationIdFromDB, applicantIdFromDB, lastNameFromDB, firstNameFromDB);
    }

    public final AdminRequestDataFromDB selectForAdminRequest(int staffId) throws SQLException {

        int staffIdFromDB = 0;
        String surnameFromDB = "";
        String passportNumberFromDB = "";

        PreparedStatement pstmt;
        ResultSet resultSet;

        String selectSQL = "SELECT * FROM reg_office.staff WHERE staffid = ?";
        pstmt = DatabaseConnection.connectToDB().prepareStatement(selectSQL);
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

        DatabaseConnection.closeConnection();

        return new AdminRequestDataFromDB(staffIdFromDB, surnameFromDB, passportNumberFromDB);

    }

}
