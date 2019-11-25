package com.blinets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maps {

  private String idMaps;

  private Point startIdPointOfRoute;

  private Point endIdPointOfRoute;

  private Route idRoute;

}
