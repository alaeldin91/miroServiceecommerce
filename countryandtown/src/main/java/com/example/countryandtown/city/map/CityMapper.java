package com.example.countryandtown.city.map;

import com.example.countryandtown.city.dto.CityDto;
import com.example.countryandtown.city.entity.City;

public class CityMapper {
    public static CityDto mapToCityDto(City city){
        CityDto cityDto = new CityDto(city.getId(),
                city.getName(),
                city.getName2(),
                city.getHieCode(),
                city.getHieDesc(),
                city.getDohCode(),
                city.getCountry(),
                city.getCountry_id());
        return cityDto;
    }
    public static  City mapToCity(CityDto cityDto){
        City city = new City(cityDto.getId(),
                cityDto.getName(),
                cityDto.getName2(),
                cityDto.getHieCode(),
                cityDto.getHieDesc(),
                cityDto.getDohCode(),
                cityDto.getCountry(),
                cityDto.getCountry_id());
        return  city;
    }
}
