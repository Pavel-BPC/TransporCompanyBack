package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.PointDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//@RolesAllowed("ADMIN")
public class PointController extends ControllersReturnRequests {

  private final CrudService<PointDto> pointServer;

  public PointController(
      CrudService<PointDto> pointServer) {
    this.pointServer = pointServer;
  }


  @GetMapping("/point")
  public ResponseEntity<List<PointDto>> getUsers() {
    return new ResponseEntity<>(pointServer.get(), HttpStatus.OK);
  }

  @GetMapping("/point/{id}")
  public ResponseEntity<PointDto> getUsers(@PathVariable String id) {
    return new ResponseEntity<>(pointServer.get(id), HttpStatus.OK);
  }

  @PostMapping("/point")
  public ResponseEntity createPoint(@RequestBody PointDto pointDto)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    pointServer.create(pointDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/point/{id}")
  public ResponseEntity delete(@PathVariable String id) {
    pointServer.remove(id);
    return returnOkRequest();
  }

  @PutMapping("/point/{id}")
  public ResponseEntity update(@RequestBody PointDto pointDto,@PathVariable String id)
      throws DontExistsObjectInDatabaseException {
    pointDto.setIdPoint(id);
    pointServer.update(pointDto);
    return returnOkRequest();
  }


}
