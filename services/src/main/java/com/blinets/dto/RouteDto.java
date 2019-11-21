package com.blinets.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

  private String pointDtoStart;

  private String pointDtoEnd;

  private String idTransport;

  private Integer distance;

  private Integer cost;

  private LocalDate time;

}
