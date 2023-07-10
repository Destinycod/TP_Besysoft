package com.besysoft.integrador.model.bussines.dto;

import com.besysoft.integrador.model.domain.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.codehaus.jackson.annotate.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class VehicleDTO {

    private Long id;
    private int year;
    @Size(min = 1, max = 255, message = "The color must have a minimum of 1 character and a maximum of 255 characters.")
    private String color;
    @Pattern(regexp = "^[A-Za-z]+$", message = "Only characters from A - Z are allowed.")
    @Size(min = 1, max = 255, message = "The brand must have a minimum of 1 character and a maximum of 255 characters.")
    private String brand;
    @Size(min = 1, max = 255, message = "The model must have a minimum of 1 character and a maximum of 255 characters.")
    private String model;
    @NotEmpty(message = "It does not admit null values nor can it remain empty.")
    @Size(min = 1, max = 255, message = "The patent must have a minimum of 1 character and a maximum of 255 characters.")
    private String patent;

    @JsonIgnoreProperties({"vehicles"})
    //@JsonIgnore
    private List<Client> clients;
}
