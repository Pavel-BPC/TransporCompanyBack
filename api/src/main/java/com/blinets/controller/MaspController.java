package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.CompanyDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import java.util.Map;
import jdk.nashorn.internal.ir.ObjectNode;
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

  @GetMapping("/map")
  public ResponseEntity get() {
    String as = "[\n"
        + "    {\n"
        + "        \"id\": \"1\",\n"
        + "        \"end_point\": \"1\",\n"
        + "        \"start_point\": \"1\",\n"
        + "        \"distance\": \"1\",\n"
        + "        \"cost\": \"1\",\n"
        + "        \"time\": \"1\"\n"
        + "    },\n"
        + "    {\n"
        + "        \"id\": \"2\",\n"
        + "        \"end_point\": \"2\",\n"
        + "        \"start_point\": \"2\",\n"
        + "        \"distance\": \"2\",\n"
        + "        \"cost\": \"2\",\n"
        + "        \"time\": \"2\"\n"
        + "    },\n"
        + "    {\n"
        + "          \"id\": \"3\",\n"
        + "        \"end_point\": \"3\",\n"
        + "        \"start_point\": \"3\",\n"
        + "        \"distance\": \"3\",\n"
        + "        \"cost\": \"3\",\n"
        + "        \"time\": \"3\"\n"
        + "    },\n"
        + "    {\n"
        + "          \"id\": \"4\",\n"
        + "        \"end_point\": \"4\",\n"
        + "        \"start_point\": \"4\",\n"
        + "        \"distance\": \"4\",\n"
        + "        \"cost\": \"4\",\n"
        + "        \"time\": \"4\"\n"
        + "    }\n"
        + "    ,\n"
        + "    {\n"
        + "          \"id\": \"5\",\n"
        + "        \"end_point\": \"5\",\n"
        + "        \"start_point\": \"5\",\n"
        + "        \"distance\": \"5\",\n"
        + "        \"cost\": \"5\",\n"
        + "        \"time\": \"5\"\n"
        + "    }\n"
        + "]";
    return new ResponseEntity<>(as, HttpStatus.OK);
  }


  @GetMapping("/map/{id}")
  public ResponseEntity<String> getCompany(@PathVariable String id) {
    String s = " {\n"
        + "          \"id\": \"5\",\n"
        + "        \"end_point\": \"5\",\n"
        + "        \"start_point\": \"5\",\n"
        + "        \"distance\": \"5\",\n"
        + "        \"cost\": \"5\",\n"
        + "        \"time\": \"5\"\n"
        + "    }";
    return new ResponseEntity<>(s, HttpStatus.OK);
  }

  @PostMapping("/map")
  public ResponseEntity createCompany(@RequestBody ObjectNode companyDto)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }

  @DeleteMapping("/map/{id}")
  public ResponseEntity delete(@PathVariable String id) {
    return returnOkRequest();
  }

  @PatchMapping("/map")
  public ResponseEntity update(@RequestBody ObjectNode companyDto)
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }
}
