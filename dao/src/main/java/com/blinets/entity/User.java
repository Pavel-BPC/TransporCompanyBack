package com.blinets.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_s")
public class User {

//  public User(String idUser, String login, String password, String roles,
//      String permissions, int active) {
//    this.idUser = idUser;
//    this.login = login;
//    this.password = password;
//    this.roles = roles;
//    this.permissions = permissions;
//    this.active = active;
//  }

  //  @Column
//  private Boolean isResolve;
//  @Column

  @Id
  @Column(name = "id_user")
  private String idUser;
  @Column
  private String fullName;
  @Column
  private String login;
  @Column
  private String password;
  @Column
  private String email;
  @Column
  private String phoneNumber;

  private String roles;
//  public List<String> roles;

//  private String permissions = "";

//  private int active;
//
//  public List<String> getRoleList() {
//    if (this.roles.length() > 0) {
//      return Arrays.asList(this.roles.split(","));
//    }
//    return new ArrayList<>();
//  }
//
//  public List<String> getPermissionList() {
//    if (this.permissions.length() > 0) {
//      return Arrays.asList(this.permissions.split(","));
//    }
//    return new ArrayList<>();
//  }
}
