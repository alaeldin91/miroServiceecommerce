package com.example.countryandtown.city.service;

import com.example.countryandtown.city.dto.CityDto;
import com.example.countryandtown.city.entity.City;
import com.example.countryandtown.city.map.CityMapper;
import com.example.countryandtown.city.repository.CityRepository;
import com.example.countryandtown.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements  CityService{
    private CityRepository cityRepository;
    @Override
    public Iterable<CityDto> saveAllCity(List<CityDto> cityDtoList) {
        List<City> cityList = cityDtoList.stream().map(cityDto -> CityMapper.mapToCity(cityDto)).toList();
        List<City> saveCities = cityRepository.saveAll(cityList);
        List<CityDto> saveCityListDto = saveCities.stream().map(city -> CityMapper.mapToCityDto(city)).toList();
        return saveCityListDto;
    }

    @Override
    public Iterable<CityDto> getAllCity() {
        List<City> cityList = cityRepository.findAll();
        List<CityDto> cityDtoList = cityList.stream().map(city -> CityMapper.mapToCityDto(city)).toList();
        return cityDtoList;
    }

    @Override
    public List<CityDto> getCityByCountryId(long countryId) {
        List<City> cityList = cityRepository.findByCountryId(countryId)
                .orElseThrow(()->new ResourceNotFoundException("city","countryId",(int)countryId));
        List<CityDto> cityDtoList = cityList.stream().map(cityDto->CityMapper.mapToCityDto(cityDto)).toList();
        return cityDtoList;
    }

    @Override
    public CityDto getCityByName(String cityName) {
        City city = cityRepository.findByName(cityName).orElseThrow();
        CityDto cityDto = CityMapper.mapToCityDto(city);
        return cityDto;
    }
}
