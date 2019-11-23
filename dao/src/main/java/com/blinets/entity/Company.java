package com.blinets.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
  @Column
  private String phoneCompany;
  @Column
  private String emailCompany;
  @Column
  private String description;


}
