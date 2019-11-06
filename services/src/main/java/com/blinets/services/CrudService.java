package com.blinets.services;

import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import java.util.List;

/**
 * Defines default methods of work with services @ param <T> determine the type of use value
 */
public interface CrudService<T> {

  String create(T object) throws DontExistsObjectInDatabaseException, UniqueObjectException;

  List<T> get();

  T get(String id);

  void remove(String id);

  void update(T object) throws DontExistsObjectInDatabaseException;

}
