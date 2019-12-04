package com.blinets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

  @JsonProperty("id")
  private String idCompany;
  @JsonProperty("name_company")
  private String nameCompany;
  @JsonProperty("phone_number_company")
  private String phoneCompany;
  @JsonProperty("email_company")
  private String emailCompany;
  @JsonProperty("description_company")
  private String description;

}
