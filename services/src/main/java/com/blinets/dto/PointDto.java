package com.blinets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointDto {

  @JsonProperty("id")
  private String idPoint;

  @JsonProperty("name_point")
  private String namePoint;

}
