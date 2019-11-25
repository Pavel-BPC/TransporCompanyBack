package com.blinets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  private String idProduct;

  private String idUser;

  private Integer weightProduct;

  private Integer volumeProduct;

  private String typeProduct;

  private UserOrder userOrder;


}
