package com.example.orders.service;

import com.example.orders.dto.OrdersDto;
import com.example.orders.dto.PurchaseResponse;
import com.example.orders.dto.Purches;
import org.springframework.data.domain.Page;

public interface CheckOutService {
PurchaseResponse placeOrder(Purches purches);
Page<OrdersDto> findByCustomerEmail(String email, int page, int Size);

}
