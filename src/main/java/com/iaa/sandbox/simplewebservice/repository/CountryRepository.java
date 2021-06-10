package com.iaa.sandbox.simplewebservice.repository;

import com.iaa.sandbox.simplewebservice.model.Country;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

  Optional<Country> findByCountryCode(String countryCode);
}
