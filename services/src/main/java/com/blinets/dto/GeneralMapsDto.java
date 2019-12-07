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
  private String nameEndPoint;
  @JsonProperty("start_point")
  private String nameStartPoint;
  @JsonProperty("distance")
  private String generalDistance;
  @JsonProperty("cost")
  private String generalCost;
  @JsonProperty("time")
  private String generalTime;
  @JsonProperty("points")
  private List<PointDto> pointList;


}