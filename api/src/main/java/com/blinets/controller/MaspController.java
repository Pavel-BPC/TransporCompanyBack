package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.GeneralMapsDto;
import com.blinets.dto.MapsDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.imp.MapsService;
import java.util.List;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private MapsService mapsService;

  @GetMapping("/map/{id}")
  public ResponseEntity<GeneralMapsDto> getMapById(@PathVariable String id) {

    return new ResponseEntity<>(mapsService.getGeneralMapsDtoWithPoints(id), HttpStatus.OK);
  }

  @GetMapping("/map/carrier")
  public ResponseEntity getMapForCarrier() {
    return new ResponseEntity<>(mapsService.getGeneralMapDtoByIdMap(), HttpStatus.OK);
  }

  @GetMapping("/map")
  public ResponseEntity<List<GeneralMapsDto>> getAllMap() {
    return new ResponseEntity<>(mapsService.getGeneralListMapsDtoWithPoints(), HttpStatus.OK);
  }

  @PostMapping("/map")
  public ResponseEntity<String> createMap(@RequestBody MapsDto mapsDto)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    return new ResponseEntity<>(mapsService.create(mapsDto), HttpStatus.OK);
  }

  @DeleteMapping("/map/{id}")
  public ResponseEntity deleteMap(@PathVariable String id) {

    mapsService.remove(id);
    return returnOkRequest()  ;
  }

  @PatchMapping("/map")
  public ResponseEntity updateMap(@RequestBody ObjectNode companyDto)
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }
}

