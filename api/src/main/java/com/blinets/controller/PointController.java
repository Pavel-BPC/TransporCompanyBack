package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.PointDto;
import com.blinets.entity.Point;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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
//@RolesAllowed("ADMIN")
public class PointController extends ControllersReturnRequests {


  @GetMapping("/point")
  public ResponseEntity<List<PointDto>> getUsers() {
    List<PointDto> points = Arrays.asList(
        new PointDto(UUID.randomUUID().toString(), "Клецк"),
        new PointDto(UUID.randomUUID().toString(), "Солигорск"),
        new PointDto(UUID.randomUUID().toString(), "Минск"),
        new PointDto(UUID.randomUUID().toString(), "Гродно"),
        new PointDto(UUID.randomUUID().toString(), "Орша"),
        new PointDto(UUID.randomUUID().toString(), "Речица")
    );
    return new ResponseEntity<>(points, HttpStatus.OK);
  }

  @GetMapping("/point/{id}")
  public ResponseEntity<PointDto> getUsers(@PathVariable String id) {
    return new ResponseEntity<>(new PointDto(UUID.randomUUID().toString(), "Клецк"), HttpStatus.OK);
  }

  @PostMapping("/point")
  public ResponseEntity createPoint(@RequestBody PointDto pointDto)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }

  @DeleteMapping("/point/{id}")
  public ResponseEntity delete(@PathVariable String id) {
    return returnOkRequest();
  }

  @PatchMapping("/point")
  public ResponseEntity update(@RequestBody PointDto pointDto)
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }


}
