package com.blinets.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transport")
public class Transport  {

  @Id
  @Column(name = "id_transport")
  private String idTransport;

  @Column
  private String nameTransport;

  @Column
  private Integer speed;

  @Column
  private Integer maxWeight;

  @Column
  private Integer tariffPlan;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "id_company", nullable = false)
  private Company company;

}
