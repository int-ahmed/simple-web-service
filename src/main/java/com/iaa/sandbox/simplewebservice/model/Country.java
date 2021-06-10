package com.iaa.sandbox.simplewebservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Country {

  @Id
  private long id;
  private String name;
  private String countryCode;
  private String currency;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "country")
  private List<State> states = new ArrayList<>();

  public long getTotalPopulation() {
    return this.states.stream().mapToLong(State::getPopulation).sum();
  }
}
