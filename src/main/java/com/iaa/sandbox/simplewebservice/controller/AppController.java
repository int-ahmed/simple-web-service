package com.iaa.sandbox.simplewebservice.controller;

import com.iaa.sandbox.simplewebservice.model.State;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AppController {

  final DataService dataService;

  public AppController(DataService dataService) {
    this.dataService = dataService;
  }

  @GetMapping("/getAllCountryPopulations")
  public ResponseEntity<?> getAllCountryPopulations() {
    Map<String, Long> populationMap = dataService.getPopulationMap();
    return ResponseEntity.ok(populationMap);
  }

  @GetMapping("/getAllCountryCurrencyCode")
  public ResponseEntity<?> getAllCountryCurrencyCode() {
    Map<String, String> countries = dataService.getAllCountiesWithCodes();
    return ResponseEntity.ok(countries);
  }

  @GetMapping("/validState")
  public boolean isValidState(@RequestParam String countryCode, @RequestParam String state_code) {
    return dataService.isValidStateForCountry(state_code, countryCode);
  }

  @PutMapping("/addState")
  public ResponseEntity<State> addState(@RequestParam String countryCode,
      @RequestParam String stateCode, @RequestParam String stateName,
      @RequestParam long statePopulation) {

    State state = new State();
    state.setStateCode(stateCode);
    state.setName(stateName);
    state.setPopulation(statePopulation);
    dataService.addState(state, countryCode);
    return ResponseEntity.ok(state);
  }
}
