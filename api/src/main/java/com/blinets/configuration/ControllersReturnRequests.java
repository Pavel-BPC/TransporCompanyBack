package com.blinets.configuration;

import static org.springframework.http.HttpHeaders.LOCATION;

import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ControllersReturnRequests {

  protected ResponseEntity returnBedRequestIfError(BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return new ResponseEntity<>(
          bindingResult.getAllErrors().stream()
              .map(ObjectError::getCode)
              .collect(Collectors.joining("; ")),
          HttpStatus.BAD_REQUEST
      );
    } else {
      return null;
    }
  }

  protected ResponseEntity returnCreatedRequest(String headerValue) {
    HttpHeaders headers = new HttpHeaders();
    headers.add(LOCATION, headerValue);
    return new ResponseEntity<>(
        new OperationStatusDto(HttpStatus.CREATED, "success"),
        headers, HttpStatus.CREATED);
  }

  protected ResponseEntity returnOkRequest() {
    return new ResponseEntity<>(
        new OperationStatusDto(HttpStatus.OK, "success"),
        HttpStatus.OK
    );
  }
}
