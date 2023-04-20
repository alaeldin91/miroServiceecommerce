package com.example.countryandtown.state.Repository;

import com.example.countryandtown.state.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StateRepository extends JpaRepository<State,Long> {
    Optional<List<State>> findByCountryId(long id);
    Optional<State>findByName(String countryName);
}
