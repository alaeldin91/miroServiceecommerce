package com.example.orders.service;

import com.example.orders.dto.OrdersDto;
import com.example.orders.dto.PurchaseResponse;
import com.example.orders.dto.Purches;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CheckOutService {
PurchaseResponse placeOrder(Purches purches);
List<OrdersDto> findByCustomerEmail(String email);

}
