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

  private String role;

  private int active;


  private String permissions;

  public User() {
  }

  public User(String idUser, String login, String password, String role, String permissions) {
    this.idUser = idUser;
    this.loginEmail = login;
    this.password = password;
    this.role = role;
    this.permissions = permissions;
    this.active = 1;
  }

  public List<String> getRoleList() {
    if (this.role.length() > 0) {
      return Arrays.asList(this.role.split(","));
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
