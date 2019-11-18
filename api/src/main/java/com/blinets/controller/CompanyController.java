package com.blinets.controller;

import com.blinets.dto.CompanyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CompanyController {

  @PostMapping("/company")
  public ResponseEntity<CompanyDto> create(CompanyDto companyDto ){

    return new ResponseEntity<>(companyDto, HttpStatus.OK);
  }

}
