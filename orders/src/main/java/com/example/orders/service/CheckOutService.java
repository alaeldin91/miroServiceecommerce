package com.example.orders.service;

import com.example.orders.dto.PurchaseResponse;
import com.example.orders.dto.Purches;

public interface CheckOutService {
PurchaseResponse placeOrder(Purches purches);
}
