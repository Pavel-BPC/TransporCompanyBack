package com.blinets.services.imp;

import com.blinets.dto.UserDto;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.mapper.UserMapper;
import com.blinets.repository.UserRepository;
import com.blinets.services.CrudService;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
public class UserServices implements CrudService<UserDto> {

  private final UserRepository userRepository;
  private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @Autowired
  public UserServices(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

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
