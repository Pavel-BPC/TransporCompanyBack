package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.TransportDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import com.blinets.services.imp.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private CrudService<TransportDto> transportService;

  @GetMapping("/transport/{id}")
  public ResponseEntity get(@PathVariable String id){
    return new ResponseEntity(transportService.get(id), HttpStatus.OK);
  }

  @GetMapping("/transports")
  public ResponseEntity getList(){
    return new ResponseEntity(transportService.get(), HttpStatus.OK);
  }

  @DeleteMapping("/transport/{id}")
  public ResponseEntity delete(@PathVariable String id){
    transportService.remove(id);
    return new ResponseEntity( HttpStatus.OK);
  }


  @PostMapping("/transport")
  public ResponseEntity create(@RequestBody TransportDto  transportDto )
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    return new ResponseEntity(transportService.create(transportDto), HttpStatus.OK);
  }






}
