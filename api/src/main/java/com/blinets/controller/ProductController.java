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
    String s1 = "[";
    String s2 = "]";
    String as = " {\n"
        + "  \"name_product\": \"1\"\n"
        + "  }";
    String s = new String(as);
    for (int i = 1; i < 6; i++) {
      as += "," + s.replace("1", String.valueOf(i + 1));
    }
    s1 += as;
    s1 += s2;
    return new ResponseEntity<>(s1, HttpStatus.OK);
  }

  @GetMapping("/product/carrier/optimal/map/{id}")
  public ResponseEntity<String> getOptimalProductForMap(@PathVariable String id) {
    String s1 = "[";
    String s2 = "]";
    String as = " {\n"
        + "  \"name_product\": \"1\"\n"
        + "  }";
    String s = new String(as);
    for (int i = 1; i < 2; i++) {
      as += "," + s.replace("1", String.valueOf(i + 1));
    }
    s1 += as;
    s1 += s2;
    return new ResponseEntity<>(s1, HttpStatus.OK);
  }

}
