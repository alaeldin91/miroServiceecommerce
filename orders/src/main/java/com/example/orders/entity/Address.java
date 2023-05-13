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
    private String country;
    @Column(name = "town_name",nullable = false)
    private String town;

    @Column(name = "state_name")
    private String state;
    @Column(name = "street_name")
    private String street;
   @OneToOne()
    @PrimaryKeyJoinColumn
    private Orders orders;
}
