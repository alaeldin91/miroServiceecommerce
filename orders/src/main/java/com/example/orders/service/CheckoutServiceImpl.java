package com.example.orders.service;

import com.example.orders.dto.PurchaseResponse;
import com.example.orders.dto.Purches;
import com.example.orders.entity.Customer;
import com.example.orders.entity.Orders;
import com.example.orders.entity.OrdersItem;
import com.example.orders.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@Getter
@Setter
@AllArgsConstructor
public class CheckoutServiceImpl  implements  CheckOutService{
    private final CustomerRepository customerRepository;
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purches purches) {
        // retrieve the order info from dto
        Orders order = purches.getOrders();

        //generate tracking number
        String trackingNumber = generateTrackingNumber();
        order.setOrderTrackingName(trackingNumber);
        //populate order with order items
        Set<OrdersItem> ordersItemSet = purches.getOrdersItemSet();
        ordersItemSet.forEach(ordersItem -> order.add(ordersItem));
        //populate order with shipping Address  and billing address
        order.setBillingAddress(purches.getBillingAddress());
        order.setShippingAddress(purches.getShippingAddress());
        //populate customer with Order
        Customer customer = purches.getCustomer();
        customer.add(order);
        //save to the dataBase
        customerRepository.save(customer);
        // return Response
        return new PurchaseResponse(trackingNumber);
    }

    private String generateTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
