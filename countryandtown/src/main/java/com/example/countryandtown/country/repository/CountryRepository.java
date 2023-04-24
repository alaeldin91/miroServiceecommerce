package com.example.countryandtown.country.repository;

import com.example.countryandtown.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:4200")
@Repository()
public interface CountryRepository extends JpaRepository<Country,Long> {
    Optional<Country> findByName(String countryName);
}
