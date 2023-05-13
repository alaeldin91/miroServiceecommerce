package com.example.orders.dto;

import com.example.orders.entity.Orders;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressDto {

    private int id;
    private String country;
    private String town;

    private String state;
    private String street;
   private Orders orders;
}
