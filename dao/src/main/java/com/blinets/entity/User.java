package com.blinets.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

  @Column
  private Boolean isResolve;

  private String roles = "";

  private String permissions = "";

  private int active;

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
