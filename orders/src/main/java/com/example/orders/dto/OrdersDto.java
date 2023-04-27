package com.example.orders.dto;

import com.example.orders.entity.Address;
import com.example.orders.entity.Customer;
import com.example.orders.entity.OrdersItem;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {
    private int id;
    private String orderTrackingName;
    private int totalQuantity;
    private String status;
    private Date createdDate;
    private Date updateDate;
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Set<OrdersItem> ordersItems;


}
