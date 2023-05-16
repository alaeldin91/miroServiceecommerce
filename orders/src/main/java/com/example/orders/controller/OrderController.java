package com.example.orders.controller;

import com.example.orders.dto.OrdersDto;
import com.example.orders.dto.PurchaseResponse;
import com.example.orders.dto.Purches;
import com.example.orders.entity.Orders;
import com.example.orders.service.CheckOutService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/v1/order")
public class OrderController {

    private final CheckOutService checkOutService;
    @PostMapping("/placeOrder")
    public ResponseEntity<PurchaseResponse> placeOrder( @RequestBody Purches purches){
        PurchaseResponse purchaseResponse =  checkOutService.placeOrder(purches);
        return new ResponseEntity<>(purchaseResponse, HttpStatus.CREATED);
    }
    @GetMapping("searchOrders/{email}")
    public ResponseEntity<List<OrdersDto>> getOrdersByEmail(@PathVariable("email")String email){
        List<OrdersDto> ordersDtoPage = checkOutService.findByCustomerEmail(email);
        return new ResponseEntity<>(ordersDtoPage,HttpStatus.OK);
    }
}
