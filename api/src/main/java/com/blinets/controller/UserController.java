package com.blinets.controller;

import com.blinets.Application;
import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.UserDto;
import com.blinets.entity.User;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.repository.UserRepository;
import com.blinets.services.CrudService;
import com.blinets.services.imp.UserServices;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
  public UserController(CrudService<UserDto> userServices, UserRepository userRepository,
      PasswordEncoder passwordEncoder) {
    this.userServices = userServices;
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }


  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;



  @GetMapping("/users")
  public ResponseEntity getUsers() {

//    userRepository.deleteAll();
//
//    // Crete users
//    User dan = new User("1","user",passwordEncoder.encode("user"),"USER","",1);
//    User admin = new User("2","admin",passwordEncoder.encode("admin"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2",1);
//    User manager = new User("3","manager",passwordEncoder.encode("manager"),"MANAGER","ACCESS_TEST1",1);
//    System.out.println("sssssss");
//    System.out.println(passwordEncoder.encode("admin"));
//    List<User> users = Arrays.asList(dan,admin,manager);
//
//    // Save to db
//      userRepository.saveAll(users);
    return returnOkRequest();
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
  public ResponseEntity patchUser(@PathVariable String id, @RequestBody String  approve)
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }


}
