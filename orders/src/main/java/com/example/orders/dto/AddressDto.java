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
    private String countryName;
    private String townName;

    private String stateName;
    private String streetName;
   private Orders orders;
}
