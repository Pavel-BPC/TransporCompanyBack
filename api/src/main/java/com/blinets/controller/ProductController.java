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
    String s = new String(
        "[{\"id\":\"bd640fde-0bfa-4407-8166-d9f37d57637b\",\"name\":\"Столы\",\"weight\":75},{\"id\":\"cb24e7cf-4e4b-4c20-8e75-80680fa15cf4\",\"name\":\"Уголь\",\"weight\":100},{\"id\":\"470d7215-8801-455d-a9f8-7c30fdfbe97a\",\"name\":\"Торф\",\"weight\":100},{\"id\":\"c020584c-f463-4b56-815c-40969eebf093\",\"name\":\"Стаканчики\",\"weight\":50}]");
    return new ResponseEntity<>(s, HttpStatus.OK);
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
