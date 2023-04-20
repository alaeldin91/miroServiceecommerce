package com.example.countryandtown.city.service;

import com.example.countryandtown.city.dto.CityDto;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public interface CityService {
    Iterable<CityDto> saveAllCity(List<CityDto> cityDtoList);
    Iterable<CityDto> getAllCity();
    List<CityDto>getCityByCountryId(long countryId);
    CityDto  getCityByName(String cityName);
}
