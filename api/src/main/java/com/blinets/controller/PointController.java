package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.PointDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointController extends ControllersReturnRequests {

  private final CrudService<PointDto> pointServer;

  public PointController(
      CrudService<PointDto> pointServer) {
    this.pointServer = pointServer;
  }


  @GetMapping("/points")
  public ResponseEntity<List<PointDto>> getUsers() {
    return new ResponseEntity<>(pointServer.get(), HttpStatus.OK);
  }

  @PostMapping("/point")
  public ResponseEntity<String> createPoint(@RequestBody PointDto pointDto)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    return new ResponseEntity<>(pointServer.create(pointDto), HttpStatus.OK);
  }

  @DeleteMapping("/point/{id}")
  public ResponseEntity delete(@RequestParam String id) {
    pointServer.remove(id);
    return returnOkRequest();
  }

  @PatchMapping("/point")
  public ResponseEntity update(@RequestBody PointDto pointDto)
      throws DontExistsObjectInDatabaseException {
    pointServer.update(pointDto);
    return returnOkRequest();
  }


}
