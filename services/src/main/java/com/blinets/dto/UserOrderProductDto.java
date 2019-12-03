package com.blinets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderProductDto {


  @JsonProperty("start_point")
  private String startPoint;
  @JsonProperty("end_point")
  private String endPoint;
  @JsonProperty("weight_product")
  private Integer weightProduct;
  @JsonProperty("name_product")
  private String name;
  @JsonProperty("type_product")
  private String typeProduct;
  @JsonProperty("id_user")
  private String idUser;

}
