package com.example.countryandtown.country.repository;

import com.example.countryandtown.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country,Long> {
    Optional<Country> findByName(String countryName);
}
