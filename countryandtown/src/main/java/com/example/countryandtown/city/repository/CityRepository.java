package com.example.countryandtown.city.repository;

import com.example.countryandtown.city.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long> {
    Optional<List<City>> findByCountryId(long countryId);
    Optional<City> findByName(String name);
}
