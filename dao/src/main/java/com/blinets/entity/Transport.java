package com.blinets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Transport {

  private String idTransport;

  private String nameTransport;

  private Integer speed;

  private Integer maxWeight;

  private Integer tariffPlan;

  private Company company;

}
