package com.blinets.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_order")
public class UserOrder {

  @Id
  @Column(name = "id_user_order")
  private String idOrder;

  @Column
  private Integer price;

  @Column
  private String status;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "id_user", nullable = false)
  private User user;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_maps", nullable = false)
  private Maps maps;

}
