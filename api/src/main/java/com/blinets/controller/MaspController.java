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

  @GetMapping("/map/{id}")
  public ResponseEntity get(@PathVariable String id) {

    String as = "{\n"
        + "  \"id\": \"1\",\n"
        + "  \"end_point\": \"1\",\n"
        + "  \"start_point\": \"1\",\n"
        + "  \"distance\": \"1\",\n"
        + "  \"cost\": \"1\",\n"
        + "  \"time\": \"1\",\n"
        + "  \"points\": [\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    }\n"
        + "  ]\n"
        + "}";

    return new ResponseEntity<>(as.replace("1",String.valueOf(id)), HttpStatus.OK);
  }



  @GetMapping("/map")
  public ResponseEntity<String> getCompany() {
    String s1 = "[";
    String s2 = "]";
    String as = "{\n"
        + "  \"id\": \"1\",\n"
        + "  \"end_point\": \"1\",\n"
        + "  \"start_point\": \"1\",\n"
        + "  \"distance\": \"1\",\n"
        + "  \"cost\": \"1\",\n"
        + "  \"time\": \"1\",\n"
        + "  \"points\": [\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"point\": \"1\"\n"
        + "    }\n"
        + "  ]\n"
        + "}";
    String s = new String(as);
    for (int i = 1; i < 6; i++) {
      as += "," + s.replace("1",String.valueOf(i+1));
    }
    s1 += as;
    s1 += s2;
    return new ResponseEntity<>(s1, HttpStatus.OK);
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
