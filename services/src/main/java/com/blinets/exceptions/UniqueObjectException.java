package com.blinets.exceptions;

public class UniqueObjectException extends ServiceException {

  public UniqueObjectException() {
    super("Object already exists");
  }
}
