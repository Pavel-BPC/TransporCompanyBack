package com.blinets.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

  private String idUser;
  private String name;
  private String lastName;
  private String loginEmail;
  private String password;
  private String phoneNumber;

  private String roles;

  private int active;


  private String permissions;

  public User() {
  }

  public User(String idUser, String login, String password, String roles, String permissions) {
    this.idUser = idUser;
    this.loginEmail = login;
    this.password = password;
    this.roles = roles;
    this.permissions = permissions;
    this.active = 1;
  }

  public List<String> getRoleList() {
    if (this.roles.length() > 0) {
      return Arrays.asList(this.roles.split(","));
    }
    return new ArrayList<>();
  }

  public List<String> getPermissionList() {
    if (this.permissions.length() > 0) {
      return Arrays.asList(this.permissions.split(","));
    }
    return new ArrayList<>();
  }
}
