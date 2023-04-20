package com.example.countryandtown.country.controller;

import com.example.countryandtown.country.dto.CountryDto;
import com.example.countryandtown.country.service.CountryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/country")
public class CountryControlleer {
    private final CountryServiceImpl  countryService;
    @GetMapping("/counteries")
    public ResponseEntity<Iterable<CountryDto>> getAllCountry(){
        Iterable<CountryDto> countryDtoList = countryService.getAllCountry();
        return  new ResponseEntity<>(countryDtoList, HttpStatus.OK);

    }

  @GetMapping("{countryName}")
    public ResponseEntity<CountryDto> getCountryByName(@PathVariable("countryName")String countryName){
        CountryDto countryDtoList = countryService.getCountryByName(countryName);
        return new ResponseEntity<>(countryDtoList,HttpStatus.OK);
  }
  @GetMapping("{countryId}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable("countryId") long id){
         CountryDto countryDto = countryService.getCountryById(id);
         return new ResponseEntity<>(countryDto,HttpStatus.OK);
  }
}
