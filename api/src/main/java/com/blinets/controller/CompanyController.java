package com.blinets.controller;

import com.blinets.configuration.ControllersReturnRequests;
import com.blinets.dto.CompanyDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CompanyController extends ControllersReturnRequests {

  private final CrudService<CompanyDto> companyService;

  @Autowired
  public CompanyController(CrudService<CompanyDto> companyService) {
    this.companyService = companyService;
  }

  @GetMapping("/company")
  public ResponseEntity<List<CompanyDto>> getCompany() {
    return new ResponseEntity<>(companyService.get(), HttpStatus.OK);
  }

  @GetMapping("/company/{id}")
  public ResponseEntity<CompanyDto> getCompany(@PathVariable String id) {
    return new ResponseEntity<>(companyService.get(id), HttpStatus.OK);
  }

  @PostMapping("/company")
  public ResponseEntity<String> createCompany(@RequestBody CompanyDto companyDto)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
    companyService.create(companyDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/company/{id}")
  public ResponseEntity delete(@PathVariable String id) {
    companyService.remove(id);
    return returnOkRequest();
  }

  @PutMapping("/company/{id}")
  public ResponseEntity update(@RequestBody CompanyDto companyDto,@PathVariable String id)
      throws DontExistsObjectInDatabaseException {
    companyDto.setIdCompany(id);
    companyService.update(companyDto);
    return returnOkRequest();
  }
}
