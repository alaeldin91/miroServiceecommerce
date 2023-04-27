package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "country_name",nullable = false)
    private String countryName;
    @Column(name = "town_name",nullable = false)
    private String townName;

    @Column(name = "state_name")
    private String stateName;
    @Column(name = "street_name")
    private String streetName;
   @OneToOne()
    @PrimaryKeyJoinColumn
    private Orders orders;
}
