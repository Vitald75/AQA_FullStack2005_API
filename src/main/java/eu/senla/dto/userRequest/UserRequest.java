package eu.senla.dto.userRequest;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class UserRequest {
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("personalFirstName")
    private String personalFirstName;
    @JsonProperty("personalLastName")
    private String personalLastName;
    @JsonProperty("personalMiddleName")
    private String personalMiddleName;
    @JsonProperty("personalNumberOfPassport")
    private String personalNumberOfPassport;
    @JsonProperty("personalPhoneNumber")
    private String personalPhoneNumber;
    @JsonProperty("personalAddress")
    private String personalAddress;
    @JsonProperty("anotherPersonFirstName")
    private String anotherPersonFirstName;
    @JsonProperty("anotherPersonLastName")
    private String anotherPersonLastName;
    @JsonProperty("anotherPersonMiddleName")
    private String anotherPersonMiddleName;
    @JsonProperty("anotherPersonPassport")
    private String anotherPersonPassport;
    @JsonProperty("birth_of_anotoherPerson")
    private String birthOfAnotherPerson;
    @JsonProperty("birth_place")
    private String birthPlace;
    @JsonProperty("birth_father")
    private String birthFather;
    @JsonProperty("birth_mother")
    private String birthMother;
    @JsonProperty("birth_grandpa")
    private String birthGrandpa;
    @JsonProperty("birth_grandma")
    private String birthGrandma;
    @JsonProperty("newLastName")
    private String newLastName;
    @JsonProperty("citizenFirstName")
    private String citizenFirstName;
    @JsonProperty("citizenLastName")
    private String citizenLastName;
    @JsonProperty("citizenMiddleName")
    private String citizenMiddleName;
    @JsonProperty("citizenBirthDate")
    private String citizenBirthDate;
    @JsonProperty("citizenNumberOfPassport")
    private String citizenNumberOfPassport;
    @JsonProperty("citizenGender")
    private String citizenGender;
    @JsonProperty("citizenAddress")
    private String citizenAddress;
    @JsonProperty("dateOfMarriage")
    private String dateOfMarriage;
    @JsonProperty("death_dateOfDeath")
    private String deathDateOfDeath;
    @JsonProperty("death_placeOfDeath")
    private String deathPlaceOfDeath;
}


