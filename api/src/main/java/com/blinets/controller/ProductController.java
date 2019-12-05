package com.blinets.controller;

import com.blinets.dto.ProductDto;
import com.blinets.services.imp.MapsService;
import com.blinets.services.imp.UserOrderProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ProductController {

  @Autowired
  private UserOrderProductService userOrderProductService;
 @Autowired
  private MapsService mapsService ;

  @GetMapping("/product/carrier/map/{id}")
  public ResponseEntity<ArrayList<ProductDto>> getProductByMaps(@PathVariable String id) {
    return new ResponseEntity<>(new ArrayList<>(userOrderProductService.getProductByIdMaps(id).values()) , HttpStatus.OK);
  }

  @GetMapping("/product/carrier/optimal/map/{id}")
  public ResponseEntity<List> getOptimalProductForMap(@PathVariable String id) {

    return new ResponseEntity<>(userOrderProductService.getOptimalProduct(id), HttpStatus.OK);
  }


  @PostMapping("/product/carrier/map/{id}")
  public ResponseEntity optimalProductForMap(@PathVariable String id) {
    mapsService.saveUserOrderProduct(id);
    return new ResponseEntity(HttpStatus.OK);
  }


}
