package com.iaa.sandbox.simplewebservice.repository;

import com.iaa.sandbox.simplewebservice.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
