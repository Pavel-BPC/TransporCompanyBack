package com.blinets.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maps")
public class Maps {

  @Id
  @Column(name = "id_maps")
  private String idMaps;

//  @OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "id_point", referencedColumnName = "id_point")
//  private Point startIdPointOfRoute;
//
//  @OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "id_point", referencedColumnName = "id_point")
//  private Point endIdPointOfRoute;
//
//  @OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "id_route", referencedColumnName = "id_route")
//  private Route idRoute;

  @Column
  private Integer distance;

  @Column
  private Integer cost;

}
