package com.example.countryandtown.state.Controller;

import com.example.countryandtown.exception.ResourceNotFoundException;
import com.example.countryandtown.state.Repository.StateRepository;
import com.example.countryandtown.state.dto.StateDto;
import com.example.countryandtown.state.entity.State;
import com.example.countryandtown.state.service.StateService;
import com.example.countryandtown.state.service.StateServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/state")
@AllArgsConstructor
public class StateController {
    private final StateServiceImpl stateService;
    private final StateRepository stateRepository;

    @GetMapping("/getAllState")
    public ResponseEntity<Iterable<StateDto>> getAllState(){
    Iterable<StateDto> stateDtoList =  stateService.getAllState();
    return  new ResponseEntity<>(stateDtoList, HttpStatus.OK);
}
@GetMapping("stateCountryById/{countryId}")
    public ResponseEntity<List<StateDto>> getStateByCountry(@PathVariable("countryId") long  countryId){
    List<StateDto> stateList = stateService.getStateByCountry(countryId);
    return  new ResponseEntity<>(stateList,HttpStatus.OK);
}
@GetMapping("/{stateName}")
    public ResponseEntity <StateDto> getStateByName(@PathVariable("stateName") String stateName){
         StateDto stateDtoList = stateService.getStateByName(stateName);
     return  new ResponseEntity<>(stateDtoList,HttpStatus.OK);
    }
}
