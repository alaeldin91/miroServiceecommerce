package com.example.countryandtown.city.dto;

import com.example.countryandtown.country.entity.Country;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class CityDto {
    private long id;
    private String name;
    private String name2;
    private String hieCode;
    private String hieDesc;
    private String dohCode;
    private Country country;
    private long country_id;
}
