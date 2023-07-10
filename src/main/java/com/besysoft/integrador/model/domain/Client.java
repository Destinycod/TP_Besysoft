package com.besysoft.integrador.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "landline_phone")
    private String landlinePhone;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "codeZip", column = @Column(name = "code_zip")),
            @AttributeOverride(name = "street", column = @Column(name = "street")),
            @AttributeOverride(name = "number", column = @Column(name = "number")),
            @AttributeOverride(name = "department", column = @Column(name = "department")),
            @AttributeOverride(name = "floor", column = @Column(name = "floor")),
            @AttributeOverride(name = "city", column = @Column(name = "city"))
    })
    private Address address;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name", nullable = false)),
            @AttributeOverride(name = "lastName", column = @Column(name = "lastName", nullable = false)),
            @AttributeOverride(name = "cellphone", column = @Column(name = "cellphone"))
    })
    private PersonalData personalData;

    @JsonIgnoreProperties({"clients"})
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "rel_clients_vehicles",
            joinColumns = @JoinColumn(name = "client_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id", nullable = false)
    )
    private List<Vehicle> vehicles;

    public Client() {
        this.vehicles = new ArrayList<>();
    }

    public Client(Long id, String email, String landlinePhone, Address address, PersonalData personalData) {
        this();
        this.id = id;
        this.email = email;
        this.landlinePhone = landlinePhone;
        this.address = address;
        this.personalData = personalData;
    }
}
