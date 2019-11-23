package com.blinets.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "route")
public class Route {

  @Id
  @Column(name = "id_route")
  private String idRoute;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "start_id_point_route", nullable = false)
  private Point startIdPointOfRoute;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "end_id_point_route", nullable = false)
  private Point endIdPointOfRoute;

  @Column
  private String nextIdRoute;
  @Column
  private Integer cost;
  @Column
  private LocalDate time;
  @Column
  private Integer distance;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_transport", nullable = false)
  private Transport idTransport;

}
