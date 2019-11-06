package com.blinets.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "point")
public class Point {

  @Id
  @Column(name = "id_point")
  private String idPoint;

  @Column
  private String namePoint;

  @OneToOne(mappedBy = "route")
  private Route route;

  @OneToOne(mappedBy = "maps")
  private Maps maps;

}
