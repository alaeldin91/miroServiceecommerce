package com.example.countryandtown.city.repository;

import com.example.countryandtown.city.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:4200")
@Repository()
public interface CityRepository extends JpaRepository<City,Long> {
    Optional<List<City>> findByCountryId(long countryId);
    Optional<City> findByName(String name);
}
