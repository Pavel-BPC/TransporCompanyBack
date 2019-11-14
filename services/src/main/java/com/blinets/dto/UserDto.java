package com.blinets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private String idUser;

  private String fullName;

  private String login;

  private String password;

  private String role;

  public UserDto() {
  }

  public UserDto(String toString, String admin, String s, String user) {
    idUser = toString;
    login = admin;
    password = s;
    role = user;
  }
}
