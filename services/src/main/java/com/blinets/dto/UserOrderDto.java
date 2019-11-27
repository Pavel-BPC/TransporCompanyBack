package com.blinets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDto {

  @JsonProperty("id")
  private String idOrder;
  @JsonProperty("price")
  private Integer price;
  @JsonProperty("status")
  private String status;
  @JsonProperty("start_date")
  private LocalDate start_date;
  @JsonProperty("end_date")
  private LocalDate end_date;


}
