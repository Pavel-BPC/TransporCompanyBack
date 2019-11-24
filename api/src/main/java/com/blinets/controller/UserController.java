package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.UserDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import com.blinets.services.security.UserPrincipalDetailsService;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
//@RolesAllowed({"ADMIN"})
public class UserController extends ControllersReturnRequests {


  private final CrudService<UserDto> userServices;
  private final UserPrincipalDetailsService userPrincipalDetailsService;

  @Autowired
  public UserController(CrudService<UserDto> userServices,
      UserPrincipalDetailsService userPrincipalDetailsService) {
    this.userServices = userServices;
    this.userPrincipalDetailsService = userPrincipalDetailsService;
  }

  @GetMapping("/login")
  public ResponseEntity<java.util.Optional<com.blinets.entity.User>> login(@RequestHeader HttpHeaders user) {
    //TODO
    System.out.println();
    return new ResponseEntity<>(userPrincipalDetailsService.findByLogin("admin"),HttpStatus.OK);
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
    userServices.remove(id);
    return returnOkRequest();
  }

  @PutMapping("/user/{id}")
  public ResponseEntity editUser(@PathVariable String id, @RequestBody UserDto userDto)
      throws DontExistsObjectInDatabaseException {
    userServices.update(userDto);
    return returnOkRequest();
  }

  @PatchMapping("/user/{id}")
  public ResponseEntity patchUser(@PathVariable String id, @RequestBody String approve)
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }


}
