package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.UserDto;
import com.blinets.entity.User;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
//@RolesAllowed({"ADMIN"})
public class UserController extends ControllersReturnRequests {

  @GetMapping("/login")
  public ResponseEntity login() {
    return new ResponseEntity<>(new User("1","admin","admin","ADMIN",""), HttpStatus.OK);
  }

  @RequestMapping("/user/login")
  public Principal user(Principal user) {
    return user;
  }

  @GetMapping("/user")
  public ResponseEntity<java.util.List<UserDto>> getUser() {
    List<UserDto> userDtos = Arrays.asList(
        new UserDto("1", "name1", "lastanme1", "login", "pas", "admin", "+3751"),
        new UserDto("2", "name2", "lastanme2", "login", "pas", "admin", "+3752"),
        new UserDto("3", "name3", "lastanme3", "login", "pas", "admin", "+3753"),
        new UserDto("4", "name4", "lastanme4", "login", "pas", "admin", "+3754"),
        new UserDto("5", "name5", "lastanme5", "login", "pas", "admin", "+3755"),
        new UserDto("6", "name6", "lastanme6", "login", "pas", "admin", "+3756"),
        new UserDto("7", "name7", "lastanme7", "login", "pas", "admin", "+3757")
    );
    return new ResponseEntity<>(userDtos, HttpStatus.OK);
  }

  @PostMapping("/user")
  public ResponseEntity createUser(@RequestBody UserDto userDto,
      BindingResult bindingResult)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {

    return returnOkRequest();
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity deleteUser(@PathVariable String id) {
    return returnOkRequest();
  }

  @PutMapping("/user/{id}")
  public ResponseEntity editUser(@PathVariable String id, @RequestBody UserDto userDto)
      throws DontExistsObjectInDatabaseException {

    return returnOkRequest();
  }

  @PatchMapping("/user/{id}")
  public ResponseEntity patchUser(@PathVariable String id, @RequestBody String approve)
      throws DontExistsObjectInDatabaseException {

    return returnOkRequest();
  }


}
