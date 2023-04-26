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
@Table(name = "order_item")
public class OrdersItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "product_name")
    private String productName;
}

