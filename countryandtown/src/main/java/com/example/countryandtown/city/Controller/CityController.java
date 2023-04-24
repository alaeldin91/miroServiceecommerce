package com.example.countryandtown.city.Controller;

import com.example.countryandtown.city.dto.CityDto;
import com.example.countryandtown.city.repository.CityRepository;
import com.example.countryandtown.city.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/country/city")
public class CityController {
    private final CityService cityService;
    private final CityRepository cityRepository;

    @GetMapping("/getAllCity")
    public ResponseEntity<Iterable<CityDto>> getAllCity(){
        Iterable<CityDto> cityDtoList = cityService.getAllCity();
        return new ResponseEntity<>(cityDtoList, HttpStatus.OK);
    }
    @GetMapping("city/{cityName}")
    public ResponseEntity<CityDto> getCityByName(@PathVariable("cityName") String cityName){
        CityDto cityDto = cityService.getCityByName(cityName);
        return new ResponseEntity<>(cityDto,HttpStatus.OK);
    }
    @GetMapping("{countryId}")
    public ResponseEntity<List<CityDto>> getCityByCountry(@PathVariable("countryId") long countryId){
        List<CityDto> cityDtoList = cityService.getCityByCountryId(countryId);
        return new ResponseEntity<>(cityDtoList,HttpStatus.OK);
    }
}
