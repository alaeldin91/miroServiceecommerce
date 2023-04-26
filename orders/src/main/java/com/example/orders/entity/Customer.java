package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")

public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "first_name")
    private String firstName;
@Column(name = "last_name")
private String lastName;

@Column(name = "email")
    private String email;

}