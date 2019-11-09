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

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "start_id_point", nullable = false)
  private Point startIdPointOfRoute;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "end_id_point", nullable = false)
  private Point endIdPointOfRoute;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_route", nullable = false)
  private Route idRoute;

  @Column
  private Integer distance;

  @Column
  private Integer cost;

}
