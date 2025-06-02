package eu.senla.client.adminRequest;

import eu.senla.dto.adminRequest.AdminRequest;
import net.datafaker.Faker;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class SetupAdminRequestData {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static AdminRequest request;

    public static AdminRequest createAdminRequestData() {
        Faker faker = new Faker();
        request = new AdminRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                faker.number().digits(7),
                faker.number().digits(8),
                faker.date().birthday(18, 99).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER)
        );

        return request;
    }
}
