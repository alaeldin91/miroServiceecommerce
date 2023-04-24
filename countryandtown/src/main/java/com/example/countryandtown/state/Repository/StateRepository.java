package com.example.countryandtown.state.Repository;

import com.example.countryandtown.state.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:4200")
@Repository()
public interface StateRepository extends JpaRepository<State,Long> {
    Optional<List<State>> findByCountryId(long id);
    Optional<State>findByName(String countryName);
}
