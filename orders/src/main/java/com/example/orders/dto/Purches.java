package com.example.orders.dto;

import com.example.orders.entity.Address;
import com.example.orders.entity.Customer;
import com.example.orders.entity.Orders;
import com.example.orders.entity.OrdersItem;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purches {
    private   Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Orders order;
    private Set<OrdersItem> orderItems;
}
