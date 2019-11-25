package com.blinets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportDto {

  @JsonProperty("id")
  private String idTransport;
  @JsonProperty("id_company")
  private String idCompany;
  @JsonProperty("name_transport")
  private String nameTransport;

  private Integer speed;
  @JsonProperty("max_weight")
  private Integer maxWeight;
  @JsonProperty("tariff_plan")
  private Integer tariffPlan;
}
