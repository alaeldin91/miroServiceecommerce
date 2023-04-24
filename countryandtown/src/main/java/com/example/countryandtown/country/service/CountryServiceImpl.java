package com.example.countryandtown.country.service;

import com.example.countryandtown.country.dto.CountryDto;
import com.example.countryandtown.country.entity.Country;
import com.example.countryandtown.country.map.CountryMapper;
import com.example.countryandtown.country.repository.CountryRepository;
import com.example.countryandtown.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{
    private final CountryRepository repository;
    private WebClient webClient;
    @Override
    public Iterable<CountryDto> listCountry(List<CountryDto> countryDtoList) {
        List<Country> countryList = countryDtoList.stream().map(countryDto -> CountryMapper.mapToCountry(countryDto)).toList();
        List<Country> saveList = repository.saveAll(countryList);
        List<CountryDto> saveListDto = saveList.stream().map(country -> CountryMapper.mapToCountryDto(country)).toList();
        return saveListDto;
    }

    @Override
    public Iterable<CountryDto> getAllCountry() {
        List<Country> countryList =  repository.findAll();
        List<CountryDto> countryDtoList = countryList.stream().map(country ->
                CountryMapper.mapToCountryDto(country)).toList();
        return countryDtoList;
    }

    @Override
    public CountryDto getCountryByName(String countryName) {
        Country countryList = repository.findByName(countryName).orElseThrow();
        CountryDto countryDtoList = CountryMapper.mapToCountryDto(countryList);
        return countryDtoList;
    }

    @Override
    public CountryDto getCountryById(long countryId) {
        Country country = repository.findById(countryId).orElseThrow(()
                ->new ResourceNotFoundException("country","countryId",((int)countryId)));
        CountryDto countryDto = CountryMapper.mapToCountryDto(country);
        return countryDto;
    }
}
