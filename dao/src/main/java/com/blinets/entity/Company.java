package com.blinets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Company {

  private String idCompany;
  private String nameCompany;
  private String phoneCompany;
  private String emailCompany;
  private String description;


}
