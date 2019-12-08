package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.UserDto;
import com.blinets.entity.User;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import com.blinets.services.security.UserPrincipal;
import com.blinets.services.security.UserPrincipalDetailsService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
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
  public ResponseEntity<UserDto> login(Principal user) {
    //TODO
    UsernamePasswordAuthenticationToken user1 = (UsernamePasswordAuthenticationToken) user;
    GrantedAuthority grantedAuthority = new ArrayList<>((user1).getAuthorities()).get(0);
    UserDto userDto = new UserDto();
    userDto.setIdUser(((UserPrincipal)user1.getPrincipal()).getIdUser());
    if ("ROLE_ADMIN".equals(grantedAuthority.getAuthority())) {
      userDto.setRole("ADMIN");
    } else if ("ROLE_USER".equals(grantedAuthority.getAuthority())) {
      userDto.setRole("USER");
    }else if ("ROLE_CARRIER".equals(grantedAuthority.getAuthority())) {
      userDto.setRole("CARRIER");
    }
    return new ResponseEntity<>(userDto, HttpStatus.OK);
  }

  @GetMapping("/user")
  public ResponseEntity<List<UserDto>> getUser() {
    //TODO
    System.out.println();
    return new ResponseEntity<>(userServices.get(), HttpStatus.OK);
  }
  @GetMapping("/user/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable String id) {
    return new ResponseEntity<>(userServices.get(id), HttpStatus.OK);
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
    userDto.setIdUser(id);
    userServices.update(userDto);
    return returnOkRequest();
  }

  @PatchMapping("/user/{id}")
  public ResponseEntity patchUser(@PathVariable String id, @RequestBody String approve)
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }


}
