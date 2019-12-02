package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.UserDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import com.blinets.services.security.UserPrincipalDetailsService;
import java.security.Principal;
import java.util.ArrayList;
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

  @GetMapping("/user/login")
  public ResponseEntity<UserDto> login(Principal user) {
    //TODO
    UsernamePasswordAuthenticationToken user1 = (UsernamePasswordAuthenticationToken) user;
    GrantedAuthority grantedAuthority = new ArrayList<>((user1).getAuthorities()).get(0);
    UserDto userDto = new UserDto();
    if ("ROLE_ADMIN".equals(grantedAuthority.getAuthority())) {
      userDto.setRoles("ADMIN");
    } else if ("ROLE_USER".equals(grantedAuthority.getAuthority())) {
      userDto.setRoles("USER");
    }
    return new ResponseEntity<>(userDto, HttpStatus.OK);
  }

  @GetMapping("/user")
  public ResponseEntity<java.util.List<UserDto>> getUser() {
    //TODO
    System.out.println();
    return new ResponseEntity<>(userServices.get(), HttpStatus.OK);
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
