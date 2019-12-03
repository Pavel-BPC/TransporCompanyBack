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
  @JsonProperty("first_name")
  private String name;
  @JsonProperty("last_name")
  private String lastName;
  @JsonProperty("email")
  private String loginEmail;
  private String password;
  @JsonProperty("roles")
  private String roles;
  @JsonProperty("phone_number")
  private String phoneNumber;

}
