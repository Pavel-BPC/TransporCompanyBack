package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.UserDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import com.blinets.services.imp.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController extends ControllersReturnRequests {


  private final CrudService<UserDto> userServices;

  @Autowired
  public UserController(CrudService<UserDto> userServices) {
    this.userServices = userServices;
  }


  @GetMapping("/users")
  public ResponseEntity getUsers() {
    return returnOkRequest();
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
  public ResponseEntity patchUser(@PathVariable String id, @RequestBody String  approve)
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }


}
