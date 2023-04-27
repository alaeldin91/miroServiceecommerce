package com.example.orders.mapper;

import com.example.orders.dto.CustomerDto;
import com.example.orders.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto(customer.getId()
                                                  , customer.getFirstName(),
                                                   customer.getLastName(),
                                                   customer.getEmail(),
                                                     customer.getOrdersSet());
        return  customerDto;
    }

    public  static Customer mapToCustomer(CustomerDto customerDto){
        Customer customer = new Customer(customerDto.getId(),
                                          customerDto.getFirstName(),
                                           customerDto.getLastName(),
                                            customerDto.getEmail(),
                                             customerDto.getOrdersSet());
    return  customer;
    }
}
