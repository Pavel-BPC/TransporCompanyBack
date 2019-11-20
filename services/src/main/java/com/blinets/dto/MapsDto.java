package com.blinets.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapsDto {

  String id;
  List<PointDto> points;
  String distance;
  String cost;
  String time;

}
