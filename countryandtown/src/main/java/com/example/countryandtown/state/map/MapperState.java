package com.example.countryandtown.state.map;

import com.example.countryandtown.state.dto.StateDto;
import com.example.countryandtown.state.entity.State;

public class MapperState {
public static StateDto mapToStateDto(State state){
    StateDto stateDto = new StateDto(state.getId()
            , state.getName(),
            state.getName2()
            , state.getHieCode(),
             state.getHieDesc(),
             state.getDohCode(),
            state.getCountry()
            , state.getCountry_id());
    return  stateDto;

}
public static  State mapToState(StateDto stateDto){
    State state = new State(stateDto.getId()
            , stateDto.getName(),
            stateDto.getName2(),
            stateDto.getHieCode(),
            stateDto.getHieDesc(),
            stateDto.getDohCode(), stateDto.getCountry(),
            stateDto.getCountry_id());
    return  state;
}

}
