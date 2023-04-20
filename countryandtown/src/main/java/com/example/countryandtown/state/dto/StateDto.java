package com.example.countryandtown.state.dto;

import com.example.countryandtown.country.entity.Country;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StateDto {

    private long id;
    @NotEmpty(message = "please enter State Name")
    private String name;
    private String name2;

    private String hieCode;
    private String dohCode;
    private String hieDesc;
    private Country country;
    private long country_id;
}
