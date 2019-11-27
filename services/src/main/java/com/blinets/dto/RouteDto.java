package com.blinets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

  @JsonProperty("start_point")
  private String pointDtoStart;
  @JsonProperty("end_point")
  private String pointDtoEnd;
  @JsonProperty("transport")
  private String idTransport;
  @JsonProperty("distance")
  private Integer distance;
  @JsonProperty("cost")
  private Integer cost;
  @JsonProperty("time")
  private String time;

}
