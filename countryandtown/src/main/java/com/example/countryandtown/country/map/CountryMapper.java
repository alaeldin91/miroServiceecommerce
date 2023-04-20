package com.example.countryandtown.country.map;

import com.example.countryandtown.country.dto.CountryDto;
import com.example.countryandtown.country.entity.Country;

public class CountryMapper {
    public  static CountryDto mapToCountryDto(Country country){
         CountryDto countryDto = new CountryDto(
                 country.getId(),
                 country.getName(),
                 country.getName2(),
                 country.getCountryId(),
                 country.getAlpha2Code(),
                 country.getAlpha3Code(),
                 country.getHieCode(),
                 country.getHieDesc(),
                 country.getHieNationalityDesc(),
                 country.getState()
         );
         return  countryDto;
    }
    public  static Country mapToCountry(CountryDto countryDto){
        Country country = new Country(
                countryDto.getId(),
                countryDto.getName(),
                countryDto.getName2(),
                countryDto.getCountryId(),
                countryDto.getAlpha2Code(),
                countryDto.getAlpha3Code(),
                countryDto.getHieCode(),
                countryDto.getHieDesc(),
                countryDto.getHieNationalityDesc(),
                countryDto.getState()
        );
        return  country;
    }
}
