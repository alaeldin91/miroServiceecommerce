package com.example.countryandtown.country.service;

import com.example.countryandtown.country.dto.CountryDto;
import com.example.countryandtown.country.entity.Country;

import java.util.List;

public interface CountryService {
    Iterable<CountryDto> listCountry(List<CountryDto> countryDtoList);
    Iterable<CountryDto> getAllCountry();
    CountryDto getCountryByName(String countryName);
    CountryDto getCountryById(long countryId)
;
}
