package eu.senla.client.userRequest;

import eu.senla.dto.userRequest.UserRequest;
import net.datafaker.Faker;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class SetupUserRequestData {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static UserRequest request;

    public static UserRequest createUserRequest(String mode) {
        Faker faker = new Faker();
        request = new UserRequest(
                mode,
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                faker.number().digits(7),
                faker.number().digits(8),
                faker.address().streetAddress(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                faker.number().digits(7),
                faker.date().birthday(0, 1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER),
                faker.planet().name(),
                faker.name().maleFirstName(),
                faker.name().femaleFirstName(),
                faker.name().maleFirstName(),
                faker.name().femaleFirstName(),
                faker.name().lastName(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                faker.date().birthday(18, 90).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER),
                faker.number().digits(7),
                faker.gender().types(),
                faker.address().streetAddress(),
                faker.date().birthday(0, 1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER),
                faker.date().birthday(0, 1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER),
                faker.address().cityName()
        );
        return request;

    }


}
