package com.blinets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ProductController {

  @GetMapping("/product/carrier/map/{id}")
  public ResponseEntity<String> getProductByMaps(@PathVariable String id) {

    return new ResponseEntity<>(new String(), HttpStatus.OK);
  }

  @GetMapping("/product/carrier/optimal/map/{id}")
  public ResponseEntity<String> getOptimalProductForMap(@PathVariable String id) {

    return new ResponseEntity<>(new String(), HttpStatus.OK);
  }

}
