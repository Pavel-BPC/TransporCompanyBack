package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.CompanyDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import java.util.Arrays;
import java.util.List;
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
public class CompanyController extends ControllersReturnRequests {


  @GetMapping("/company")
  public ResponseEntity<List<CompanyDto>> getCompany() {

    List<CompanyDto> companyDtos = Arrays.asList(
        new CompanyDto("1", "name1", "1", "em1", "dec1"),
        new CompanyDto("2", "name2", "2", "em2", "dec2"),
        new CompanyDto("3", "name3", "3", "em3", "dec3"),
        new CompanyDto("4", "name4", "4", "em4", "dec4"),
        new CompanyDto("5", "name5", "5", "em5", "dec5"),
        new CompanyDto("6", "name6", "6", "em6", "dec6")

    );
    return new ResponseEntity<>(companyDtos, HttpStatus.OK);
  }

  @GetMapping("/company/{id}")
  public ResponseEntity<CompanyDto> getCompany(@PathVariable String id) {
    return new ResponseEntity<>(new CompanyDto("1", "name1", "1", "em1", "dec1"), HttpStatus.OK);
  }

  @PostMapping("/company")
  public ResponseEntity createCompany(@RequestBody CompanyDto companyDto)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }

  @DeleteMapping("/company/{id}")
  public ResponseEntity delete(@PathVariable String id) {
    return returnOkRequest();
  }

  @PatchMapping("/company")
  public ResponseEntity update(@RequestBody CompanyDto companyDto)
      throws DontExistsObjectInDatabaseException {
    return returnOkRequest();
  }
}
