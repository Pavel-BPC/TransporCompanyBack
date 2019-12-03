package com.blinets.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_s")
public class User implements Serializable {
  @Id
  @Column(name = "id_user")
  private String idUser;
  @Column
  private String name;
  @Column
  private String lastName;
  @Column
  private String loginEmail;
  @Column
  private String password;
  @Column
  private String phoneNumber;

  @Column
  private String role;

  private int active;




  public User() {
  }

  public User(String idUser, String login, String password, String role) {
    this.idUser = idUser;
    this.loginEmail = login;
    this.password = password;
    this.role = role;
    this.active = 1;
  }

  public List<String> getRoleList(){
    if(this.role.length() > 0){
      return Arrays.asList(this.role.split(","));
    }
    return new ArrayList<>();
  }

//  public List<String> getPermissionList(){
//    if(this.permissions.length() > 0){
//      return Arrays.asList(this.permissions.split(","));
//    }
//    return new ArrayList<>();
//  }
}
