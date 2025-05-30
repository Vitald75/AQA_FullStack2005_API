package eu.senla.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public record UserRequest(
    String mode,
    String personalFirstName,
    String personalLastName,
    String personalMiddleName,
    String personalNumberOfPassport,
    String personalPhoneNumber,
    String personalAddress,
    String anotherPersonFirstName,
    String anotherPersonLastName,
    String anotherPersonMiddleName,
    String anotherPersonPassport,
    @JsonProperty("birth_of_anotoherPerson")
    String birthOfAnotherPerson,
    @JsonProperty("birth_place")
    String birthPlace,
    @JsonProperty("birth_father")
    String birthFather,
    @JsonProperty("birth_mother")
    String birthMother,
    @JsonProperty("birth_grandpa")
    String birthGrandpa,
    @JsonProperty("birth_grandma")
    String birthGrandma,
    String newLastName,
    String citizenFirstName,
    String citizenLastName,
    String citizenMiddleName,
    String citizenBirthDate,
    String citizenNumberOfPassport,
    String citizenGender,
    String citizenAddress,
    String dateOfMarriage,
    @JsonProperty("death_dateOfDeath")
    String deathDateOfDeath,
    @JsonProperty("death_placeOfDeath")
    String deathPlaceOfDeath)
    {
}
