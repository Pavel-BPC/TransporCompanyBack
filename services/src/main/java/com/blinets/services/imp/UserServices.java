package com.blinets.services.imp;

import com.blinets.dto.UserDto;
import com.blinets.entity.User;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
public class UserServices implements CrudService<UserDto> {


  @Override
  public String create(UserDto object)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    return null;
  }

  @Override
  public List<UserDto> get() {
    return null;
  }

  @Override
  public UserDto get(String id) {
    return null;
  }

  @Override
  public void remove(String id) {

  }

  @Override
  public void update(UserDto object) throws DontExistsObjectInDatabaseException {

  }
}
