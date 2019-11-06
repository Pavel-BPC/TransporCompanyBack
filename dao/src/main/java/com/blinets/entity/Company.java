package com.blinets.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {

  @Id
  @Column(name = "id_company")
  private String idCompany;

  @Column
  private String nameCompany;

//  @OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
//  private List<Transport> transports;

}
