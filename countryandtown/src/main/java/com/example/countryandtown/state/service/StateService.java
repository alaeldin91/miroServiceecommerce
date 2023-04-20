package com.example.countryandtown.state.service;

import com.example.countryandtown.state.dto.StateDto;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public interface StateService {
    Iterable<StateDto> saveAllStates(List<StateDto> stateDtoList);
    Iterable<StateDto> getAllState();
    List<StateDto> getStateByCountry(long countryId);
    StateDto getStateByName(String stateName);
}
