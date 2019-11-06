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
  private Integer weight;

  @Column
  private String status;

//  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "idUser")
//  private User idUser;
//
//  @OneToOne(fetch = FetchType.EAGER, optional = false)
//  @JoinColumn(name = "idMap", nullable = false)
//  private Maps idMap;
//
//  @OneToOne(fetch = FetchType.EAGER, optional = false)
//  @JoinColumn(name = "idRoute", nullable = false)
//  private Route idRoute;

}
