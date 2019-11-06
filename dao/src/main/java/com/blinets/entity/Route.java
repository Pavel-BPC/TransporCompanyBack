package com.blinets.entity;

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

  @Column
  private String nameRoute;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_point_route", referencedColumnName = "id_point")
  private Point startIdPointOfRoute;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_point_route", referencedColumnName = "id_point")
  private Point endIdPointOfRoute;

  @Column
  private String nextIdRoute;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_transport")
  private Transport idTransport;

  @OneToOne(mappedBy = "maps")
  private Maps maps;


}
