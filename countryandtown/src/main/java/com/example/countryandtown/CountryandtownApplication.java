package com.example.countryandtown;

import com.example.countryandtown.city.dto.CityDto;
import com.example.countryandtown.city.service.CityService;
import com.example.countryandtown.country.dto.CountryDto;
import com.example.countryandtown.country.entity.Country;
import com.example.countryandtown.country.service.CountryServiceImpl;
import com.example.countryandtown.state.dto.StateDto;
import com.example.countryandtown.state.entity.State;
import com.example.countryandtown.state.service.StateServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CountryandtownApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryandtownApplication.class, args);
	}
  @Bean
	CommandLineRunner runner(CountryServiceImpl countryService){
	  Logger logger = LogManager.getLogger(CountryandtownApplication.class);
	  return args -> {
		  ObjectMapper objectMapper = new ObjectMapper();
		  TypeReference<List<CountryDto>> typeReference = new TypeReference<>(){};
		  InputStream inputStream = TypeReference.class.getResourceAsStream("/fixture/countries.json");
		  try {
          List<CountryDto> countryDto = objectMapper.readValue(inputStream,typeReference);
		  countryService.listCountry(countryDto);
			  System.out.println("Countries Saved");

		  }
		  catch(IOException exception){
			  System.out.println("Unable to save Countries: " + exception.getMessage());

		  }
	  };
  }
  @Bean
 CommandLineRunner  runnerState(StateServiceImpl stateService){
		 Logger logger = LogManager.getLogger(CountryandtownApplication.class);
		 return  args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<List<StateDto>> typeReference = new TypeReference<>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/fixture/cities.json");
			try{
                   List<StateDto> stateDtoList = objectMapper.readValue(inputStream,typeReference);
				   stateService.saveAllStates(stateDtoList);
				    System.out.println("State Saved");

			}
			catch (IOException e){
				System.out.println("Unable to save Cities: " + e.getMessage());

			}
		 };
  }
  @Bean
  CommandLineRunner runnerCity(CityService cityService){
		Logger logger =LogManager.getLogger(CountryandtownApplication.class);
       return args -> {
		   ObjectMapper objectMapper = new ObjectMapper();
		   TypeReference<List<CityDto>> typeReference = new TypeReference<>(){};
		   InputStream inputStream = TypeReference.class.getResourceAsStream("/fixture/cities.json");
		   try {
			  List<CityDto> cityDtoList = objectMapper.readValue(inputStream,typeReference);
			  cityService.saveAllCity(cityDtoList);
			   System.out.println("City Saved");

		   }
		   catch (IOException exception){
			   System.out.println("Unable to save Cities: " + exception.getMessage());

		   }
	   };
	}
}
