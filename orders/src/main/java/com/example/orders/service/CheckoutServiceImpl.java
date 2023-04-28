package com.example.orders.service;

import com.example.orders.dto.PurchaseResponse;
import com.example.orders.dto.Purches;
import com.example.orders.entity.Address;
import com.example.orders.entity.Customer;
import com.example.orders.entity.Orders;
import com.example.orders.entity.OrdersItem;
import com.example.orders.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@Getter
@Setter
@AllArgsConstructor
public class CheckoutServiceImpl  implements  CheckOutService{
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutServiceImpl.class);

    private final CustomerRepository customerRepository;
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purches purches) {
        // retrieve the order info from dto
        Orders order = purches.getOrder();

        //generate tracking number
        String trackingNumber = generateTrackingNumber();
        order.setOrderTrackingName(trackingNumber);
        //populate order with order items
        Set<OrdersItem> orderItems = purches.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        //populate order with shipping Address  and billing address
        order.setBillingAddress(purches.getBillingAddress());

        order.setShippingAddress(purches.getShippingAddress());
        //populate customer with Order
        Customer customer = purches.getCustomer();
        customer.add(order);
        //save to the dataBase
        customerRepository.save(customer);
        // return Response
        LOGGER.info("****** Order*******");
        LOGGER.info("this is "+ order.getCustomer());
        LOGGER.info("****** Tracking *******");
        LOGGER.info("this is "+ trackingNumber);

        return new PurchaseResponse(trackingNumber);
    }

    private String generateTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
