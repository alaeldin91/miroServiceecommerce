package com.example.orders.controller;

import com.example.orders.dto.PurchaseResponse;
import com.example.orders.dto.Purches;
import com.example.orders.service.CheckOutService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/order")
public class OrderController {

    private final CheckOutService checkOutService;
    @PostMapping("/placeOrder")
    public ResponseEntity<PurchaseResponse> placeOrder( @RequestBody Purches purches){
        PurchaseResponse purchaseResponse =  checkOutService.placeOrder(purches);
        return new ResponseEntity<>(purchaseResponse, HttpStatus.CREATED);
    }
}
