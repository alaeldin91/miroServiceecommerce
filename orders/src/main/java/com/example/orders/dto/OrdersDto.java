package com.example.orders.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {
    private int id;
    private String orderTrackingName;
    private int totalQuantity;
    private String status;
    private Date createdDate;
    private Date updateDate;
}
