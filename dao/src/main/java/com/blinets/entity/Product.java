package com.blinets.entity;

import com.blinets.repository.UserRepository;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "id_user_order", nullable = false)
  private UserOrder userOrder;


}
