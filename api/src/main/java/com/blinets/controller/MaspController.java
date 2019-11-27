package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.CompanyDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import java.util.Map;
import jdk.nashorn.internal.ir.ObjectNode;
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
public class MaspController extends ControllersReturnRequests {

  @GetMapping("/map")
  public ResponseEntity get() {
    return new ResponseEntity<>(new String(), HttpStatus.OK);
  }


  @GetMapping("/map/{id}")
  public ResponseEntity<String> getMap(@PathVariable String id) {
       return new ResponseEntity<>( id, HttpStatus.OK);
  }

  @PostMapping("/map")
  public ResponseEntity createMap(@RequestBody ObjectNode objectNode )
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }

  @DeleteMapping("/map/{id}")
  public ResponseEntity delete(@PathVariable String id) {
    return returnOkRequest();
  }

  @PatchMapping("/map")
  public ResponseEntity update(@RequestBody ObjectNode objectNode )
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }
}

