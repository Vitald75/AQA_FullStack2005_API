package eu.senla.dto.dbResponse;

public record UserRequestDataFromDB(
        int applicationId,
        int applicantId,
        String lastName,
        String firstName) {
}
