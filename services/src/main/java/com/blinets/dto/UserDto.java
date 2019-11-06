package com.blinets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private String idUser;

  private String fullName;

  private String login;

  private String password;

  private String email;

  private String phoneNumber;


}
