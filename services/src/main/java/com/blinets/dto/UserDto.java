package com.blinets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  @JsonProperty("id")
  private String idUser;
  @JsonProperty("full_name")
  private String fullName;
  private String login;
  private String password;
  private String role;
  @JsonProperty("phone_Number")
  private String phoneNumber;

}
