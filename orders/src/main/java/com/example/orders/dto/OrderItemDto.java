package com.example.orders.dto;

import com.example.orders.entity.Orders;
import com.example.orders.entity.OrdersItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemDto {
    private  int id;
    private String imageUrl;
    private Double unitPrice;
    private int quantity;
    private String productName;
    private Orders orders;
}
