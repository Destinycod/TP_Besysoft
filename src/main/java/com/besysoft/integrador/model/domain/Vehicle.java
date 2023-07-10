package com.besysoft.integrador.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "year")
    private int year;
    @Column(name = "color")
    private String color;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "patent", nullable = false, unique = true)
    private String patent;

    @JsonIgnoreProperties({"vehicles"})
    @ManyToMany(mappedBy = "vehicles", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Client> clients;

    public Vehicle(){
        this.clients = new ArrayList<>();
    }

    public Vehicle(Long id, int year, String color, String brand, String model, String patent) {
        this();
        this.id = id;
        this.year = year;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.patent = patent;
    }
}
