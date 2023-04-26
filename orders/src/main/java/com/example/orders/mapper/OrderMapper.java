package com.example.orders.mapper;

import com.example.orders.dto.OrdersDto;
import com.example.orders.entity.Orders;

public class OrderMapper {
    public static OrdersDto mapToOrderDto(Orders orders){
        OrdersDto ordersDto = new OrdersDto(orders.getId()
                                            , orders.getOrderTrackingName(),
                                             orders.getTotalQuantity(),
                                                orders.getStatus(),
                                                orders.getCreatedDate(),
                                               orders.getUpdateDate());
    return  ordersDto;
    }

    public static Orders mapToOrder(OrdersDto ordersDto){
        Orders orders = new Orders(
                ordersDto.getId(),
                ordersDto.getOrderTrackingName(),
                ordersDto.getTotalQuantity(),
                ordersDto.getStatus(),
                ordersDto.getCreatedDate(),
                ordersDto.getUpdateDate()
        );
        return  orders;
    }
}
