package com.besysoft.integrador.model.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String codeZip;
    private String street;
    private String number;
    private String department;
    private String floor;
    private String city;
}
