package com.besysoft.integrador.model.bussines.dto;

import com.besysoft.integrador.model.domain.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    @Email
    @NotEmpty(message = "It does not admit null values nor can it remain empty.")
    @Size(min = 5, max = 255, message = "The email must have a minimum of 5 characters " +
            "and a maximum of 255 characters.")
    private String email;
    @Size(min = 7, max = 15, message = "The landline phone must have a minimum of 7 characters and " +
            "a maximum of 15 characters.")
    @Pattern(regexp = "^[0-9]*$", message = "Only characters from 0 - 9 are allowed.")
    private String landlinePhone;

    @Size(min = 1, max = 255, message = "The code zip must have a minimum of 1 character " +
            "and a maximum of 255 characters.")
    private String codeZip;
    @Size(min = 1, max = 255, message = "The street must have a minimum of 1 character " +
            "and a maximum of 255 characters.")
    private String street;
    @Pattern(regexp = "^[0-9]*$", message = "Only characters from 0 - 9 are allowed.")
    @Size(min = 1, max = 255, message = "The number must have a minimum of 1 characters " +
            "and a maximum of 255 characters.")
    private String number;
    @Size(min = 1, max = 255, message = "The department must have a minimum of 1 characters " +
            "and a maximum of 255 characters.")
    private String department;
    @Size(min = 1, max = 255, message = "The floor must have a minimum of 5 characters " +
            "and a maximum of 255 characters.")
    private String floor;
    @Size(min = 1, max = 255, message = "The city must have a minimum of 1 character " +
            "and a maximum of 255 characters.")
    private String city;

    @NotEmpty(message = "It does not admit null values nor can it remain empty.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Only characters from A - Z are allowed.")
    @Size(min = 1, max = 100, message = "The name must have a minimum of 1 character and a maximum " +
            "of 100 characters.")
    private String name;
    @NotEmpty(message = "It does not admit null values nor can it remain empty.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Only characters from A - Z are allowed.")
    @Size(min = 1, max = 80, message = "The last name must have a minimum of 1 character and a " +
            "maximum of 80 characters.")
    private String lastName;
    @Pattern(regexp = "^[0-9]*$", message = "Only characters from 0 - 9 are allowed.")
    @Size(min = 7, max = 15, message = "The cellphone number must have a minimum of 7 characters " +
            "and a maximum of 15 characters.")
    private String cellphone;

    @JsonIgnoreProperties({"clients"})
    //@JsonIgnore
    private List<Vehicle> vehicles;
}
