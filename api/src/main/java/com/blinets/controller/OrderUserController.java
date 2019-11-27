package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.PointDto;
import com.blinets.dto.UserOrderDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderUserController extends ControllersReturnRequests {


  @GetMapping("/userOrder")
  public ResponseEntity<List<UserOrderDto>> getUserOrder() {
    List<UserOrderDto> userOrderDtos = Arrays.asList(
        new UserOrderDto("1", 1, "1", LocalDate.now(), LocalDate.now()),
        new UserOrderDto("2", 2, "2", LocalDate.now(), LocalDate.now()),
        new UserOrderDto("3", 3, "3", LocalDate.now(), LocalDate.now()),
        new UserOrderDto("4", 4, "4", LocalDate.now(), LocalDate.now()),
        new UserOrderDto("5", 5, "5", LocalDate.now(), LocalDate.now())
    );
    return new ResponseEntity<>(userOrderDtos, HttpStatus.OK);
  }

  @GetMapping("/userOrder/{id}")
  public ResponseEntity getUserOrder(@PathVariable String id) {
    return new ResponseEntity<>(new UserOrderDto("5", 5, "5", LocalDate.now(), LocalDate.now()), HttpStatus.OK);
  }

  @PostMapping("/userOrder")
  public ResponseEntity createUserOrder(@RequestBody PointDto pointDto)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }

  @DeleteMapping("/userOrder/{id}")
  public ResponseEntity deleteUserOrder(@PathVariable String id) {
    return returnOkRequest();
  }

  @PatchMapping("/userOrder")
  public ResponseEntity updateUserOrder(@RequestBody PointDto pointDto)
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }



}
