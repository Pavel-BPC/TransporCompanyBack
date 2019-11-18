package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.PointDto;
import com.blinets.dto.UserDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import java.util.Arrays;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController extends ControllersReturnRequests {


  private final CrudService<UserDto> userServices;

  @Autowired
  public UserController(CrudService<UserDto> userServices) {
    this.userServices = userServices;
  }

  @GetMapping("/login")
  public UserDto login(@RequestHeader HttpHeaders user) {
    System.out.println(user);
    UserDto admin = new UserDto(UUID.randomUUID().toString(), "admin",
        "$2a$10$tnWLPrQ41NlMvb5JFKn5p.e/vBy.l.vv8iD34pMDlMGTVoosXfoAa", "USER");

    return admin;
  }

  @GetMapping("/points")
  public ResponseEntity<java.util.List<PointDto>> getUsers() {
    PointDto point1 = new PointDto();
    PointDto point2 = new PointDto();
    point1.setId("1");
    point2.setId("2");
    point2.setName_point("fds");
    point1.setName_point("fgggggg");
    return new ResponseEntity<>( Arrays.asList(point1,point2), HttpStatus.OK);
  }

  @PostMapping("/user")
  public ResponseEntity createUser(@RequestBody UserDto userDto,
      BindingResult bindingResult)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    userServices.create(userDto);
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
