package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
private Set<Orders> ordersSet = new HashSet<>();

public void add(Orders orders){
if (orders !=null){
    if (ordersSet == null){
        ordersSet = new HashSet<>();
    }
    ordersSet.add(orders);
   orders.setCustomer(this);

}
}
}
