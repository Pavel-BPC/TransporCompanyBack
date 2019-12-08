package com.blinets.services.imp;

import com.blinets.dto.UserOrderDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.services.CrudService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserOrderService implements CrudService<UserOrderDto> {

  @Override
  public String create(UserOrderDto object)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    return null;
  }

  @Override
  public List<UserOrderDto> get() {
    return null;
  }

  @Override
  public UserOrderDto get(String id) {
    return null;
  }

  @Override
  public void remove(String id) {

  }

  @Override
  public void update(UserOrderDto object) throws DontExistsObjectInDatabaseException {

  }
}
