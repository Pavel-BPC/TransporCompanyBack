package com.blinets.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

  private String idRoute;

  private Point startIdPointOfRoute;

  private Point endIdPointOfRoute;

  private String nextIdRoute;
  private Integer cost;
  private LocalDate time;
  private Integer distance;

  private Transport idTransport;

}
