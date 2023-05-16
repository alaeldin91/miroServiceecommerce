package com.example.orders.service;

import com.example.orders.dto.CustomerDto;
import com.example.orders.dto.OrdersDto;
import com.example.orders.dto.PurchaseResponse;
import com.example.orders.dto.Purches;
import com.example.orders.entity.Address;
import com.example.orders.entity.Customer;
import com.example.orders.entity.Orders;
import com.example.orders.entity.OrdersItem;
import com.example.orders.exception.ResourceNotFoundException;
import com.example.orders.mapper.CustomerMapper;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.repository.CustomerRepository;
import com.example.orders.repository.OrderRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@Getter
@Setter
@AllArgsConstructor
public class CheckoutServiceImpl  implements  CheckOutService{
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutServiceImpl.class);

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

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
        Customer customerDB = customerRepository.findByEmail(customer.getEmail());
        if (customerDB  !=null){
           customer = customerDB;
        }
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

    @Override
    public List<OrdersDto> findByCustomerEmail(String email) {
       List<Orders> ordersContainingEmail = orderRepository.findByCustomerEmailContaining(email)
               .orElseThrow(()->new ResourceNotFoundException("orders","email",email));
               LOGGER.info("ORDERCONTAIN"+ordersContainingEmail);
        List<Orders> ordersList =  orderRepository.findByCustomerEmail(email)
                    .orElseThrow(()->
                new ResourceNotFoundException("orders","email",email));
        LOGGER.info("ORDERList"+ordersContainingEmail);

        List<OrdersDto> ordersDtoList = ordersList.stream().map(orderDto->
                OrderMapper.mapToOrderDto(orderDto)).toList();
        return ordersDtoList;
    }

    private String generateTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
