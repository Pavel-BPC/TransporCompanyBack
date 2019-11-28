package com.blinets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralMapsDto {

  @JsonProperty("id")
  private String idMap;
  @JsonProperty("end_point")
  private String name_end_point;
  @JsonProperty("start_point")
  private String name_start_point;
  @JsonProperty("distance")
  private String general_distance;
  @JsonProperty("cost")
  private String general_cost;
  @JsonProperty("points")
  private List<PointDto> pointList;


}