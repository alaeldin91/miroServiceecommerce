package com.example.countryandtown.country.dto;

import com.example.countryandtown.state.entity.State;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {
private long id;
@NotEmpty(message = "please enter name")
private String name;
    @Column(name = "name2",length = 200)
    private String name2;
    private long countryId;
    private String alpha2Code;
    private String alpha3Code;
    private String hieCode;
    private String hieDesc;
    private String hieNationalityDesc;
    private Set<State> state;


}
