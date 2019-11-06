package com.blinets.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

  @Id
  @Column(name = "id_product")
  private String idProduct;

  @Column
  private String idUser;

  @Column
  private Integer weightProduct;

  @Column
  private Integer volumeProduct;

  @Column
  private String typeProduct;

}
