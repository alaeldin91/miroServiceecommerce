package com.example.orders.mapper;

import com.example.orders.dto.OrderItemDto;
import com.example.orders.entity.OrdersItem;

public class OrderItemMapper {
    public static OrderItemDto toMapOrderItemDto(OrdersItem ordersItem){
        OrderItemDto orderItemDto = new OrderItemDto(ordersItem.getId()
                                                ,ordersItem.getImageUrl()
                                               ,ordersItem.getUnitPrice(),
                                               ordersItem.getQuantity(),
                                                ordersItem.getProductName(),ordersItem.getOrder());
        return  orderItemDto;
    }

    public static OrdersItem mapToOrderItem(OrderItemDto ordersItemDto){
         OrdersItem ordersItem = new OrdersItem(ordersItemDto.getId(),
                                         ordersItemDto.getImageUrl(),
                                         ordersItemDto.getUnitPrice(),
                                         ordersItemDto.getQuantity(),
                                         ordersItemDto.getProductName(),ordersItemDto.getOrders());
         return  ordersItem;

    }
}
