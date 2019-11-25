package com.blinets.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserOrder {

  private String idOrder;

  private Integer price;

  private String status;

  private LocalDate fullTime;
  private LocalDate startDate;
  private LocalDate endDate;


  private User user;

  private Maps maps;

}
