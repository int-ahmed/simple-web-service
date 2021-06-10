package com.iaa.sandbox.simplewebservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class State {

  @Id
  private long id;
  private String name;
  private String stateCode;
  private long population;

  @ManyToOne(fetch = FetchType.LAZY)
  private Country country;
}
