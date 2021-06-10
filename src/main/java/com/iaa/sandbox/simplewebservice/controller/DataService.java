package com.iaa.sandbox.simplewebservice.controller;

import com.iaa.sandbox.simplewebservice.model.Country;
import com.iaa.sandbox.simplewebservice.model.State;
import com.iaa.sandbox.simplewebservice.repository.CountryRepository;
import com.iaa.sandbox.simplewebservice.repository.StateRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DataService {

  final CountryRepository countryRepository;
  final StateRepository stateRepository;

  public DataService(CountryRepository countryRepository, StateRepository stateRepository) {
    this.countryRepository = countryRepository;
    this.stateRepository = stateRepository;
  }

  public Map<String, Long> getPopulationMap() {
    List<Country> countries = countryRepository.findAll();
    return countries.stream()
        .collect(Collectors.toMap(Country::getCountryCode, Country::getTotalPopulation));
  }

  public Map<String, String> getAllCountiesWithCodes() {
    List<Country> countries = countryRepository.findAll();
    return countries.stream()
        .collect(Collectors.toMap(Country::getCountryCode, Country::getCurrency));
  }

  public boolean isValidStateForCountry(String state_code, String countryCode) {

    Optional<Country> country = countryRepository.findByCountryCode(countryCode);
    if (country.isPresent()) {
      List<State> states = country.get().getStates();
      return states.stream().anyMatch(state -> state.getStateCode().equals(state_code));
    } else {
      return false;
    }
  }

  public State addState(State state, String countryCode) {
    Optional<Country> country = countryRepository.findByCountryCode(countryCode);
    country.ifPresentOrElse(state::setCountry, () -> {
      throw new RuntimeException("NotFound");
    });
    return stateRepository.save(state);
  }
}
