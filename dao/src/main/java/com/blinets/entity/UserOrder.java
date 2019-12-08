package com.blinets.entity;

import java.time.LocalDate;
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

  @Column(nullable = true)
  private Integer fullTime;
  @Column(nullable = true)
  private LocalDate startDate;
  @Column(nullable = true)
  private LocalDate endDate;


  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_user", nullable = true)
  private User user;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_maps", nullable = true)
  private Maps maps;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "start_id_point_route", nullable = false)
  private Point startIdPointOfRoute;
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "end_id_point_route", nullable = false)
  private Point endIdPointOfRoute;

}
