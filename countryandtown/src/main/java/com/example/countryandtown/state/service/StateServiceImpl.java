package com.example.countryandtown.state.service;

import com.example.countryandtown.exception.ResourceNotFoundException;
import com.example.countryandtown.state.Repository.StateRepository;
import com.example.countryandtown.state.dto.StateDto;
import com.example.countryandtown.state.entity.State;
import com.example.countryandtown.state.map.MapperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StateServiceImpl implements StateService
{
    private final StateRepository stateRepository;
    @Override
    public Iterable<StateDto> saveAllStates(List<StateDto> stateDtoList) {
        List<State> states = stateDtoList.stream().map(stateDto -> MapperState.mapToState(stateDto)).toList();
        List<State> saveStates = stateRepository.saveAll(states);
        List<StateDto> saveStateDto = saveStates.stream().map(saveState->MapperState.mapToStateDto(saveState)).toList();
        return saveStateDto;
    }

    @Override
    public Iterable<StateDto> getAllState() {
        List<State> states = stateRepository.findAll();
        List<StateDto> stateDtoList = states.stream().map(state -> MapperState.mapToStateDto(state)).toList();
        return stateDtoList;
    }

    @Override
    public List<StateDto> getStateByCountry(long countryId) {
        List<State> states = stateRepository.findByCountryId(countryId)
                .orElseThrow(()->new ResourceNotFoundException("state","countryId",(int)countryId));
        List<StateDto> stateDtoList = states.stream().map(state -> MapperState.mapToStateDto(state)).toList();
        return stateDtoList;
    }

    @Override
    public StateDto getStateByName(String stateName) {
        State states = stateRepository.findByName(stateName).orElseThrow();
        StateDto stateDto = MapperState.mapToStateDto(states);
        return stateDto;
    }
}
