package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.TransportDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TransportController extends ControllersReturnRequests {


  @GetMapping("/transport/{id}")
  public ResponseEntity<TransportDto> getTransport(@PathVariable String id) {
    return new ResponseEntity<>(new TransportDto("1", "c1", "name1", 1, 1, 1), HttpStatus.OK);
  }

  @GetMapping("/transport")
  public ResponseEntity<java.util.List<TransportDto>> getListTransport() {
    List<TransportDto> transportDtos = Arrays.asList(
        new TransportDto("1", "c1", "name1", 1, 1, 1),
        new TransportDto("2", "c2", "name2", 2, 2, 2),
        new TransportDto("3", "c3", "name3", 3, 3, 3),
        new TransportDto("4", "c4", "name4", 4, 4, 4),
        new TransportDto("5", "c5", "name5", 5, 5, 5),
        new TransportDto("6", "c6", "name6", 6, 6, 6)

    );
    return new ResponseEntity<>(transportDtos, HttpStatus.OK);
  }

  @DeleteMapping("/transport/{id}")
  public ResponseEntity deleteTransport(@PathVariable String id) {

    return new ResponseEntity(HttpStatus.OK);
  }


  @PostMapping("/transport")
  public ResponseEntity createTransport(@RequestBody TransportDto transportDto)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }


}
