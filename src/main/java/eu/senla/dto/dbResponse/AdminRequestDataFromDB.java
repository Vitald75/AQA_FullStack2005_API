package eu.senla.dto.dbResponse;

public record AdminRequestDataFromDB(
        int staffId,
        String lastName,
        String passport) {
}
