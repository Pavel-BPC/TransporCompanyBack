package com.blinets.services.imp;

import com.blinets.dto.UserDto;
import com.blinets.entity.User;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.mapper.UserMapper;
import com.blinets.repository.UserRepository;
import com.blinets.services.CrudService;
import java.util.List;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

@Log4j2
@Service
public class UserServices implements CrudService<UserDto> {

  private final UserRepository userRepository;
  private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @Autowired
  public UserServices(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public String create(UserDto userDto )
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    User user = userMapper.dtoToUser(userDto);
    user.setIdUser(UUID.randomUUID().toString());
    userRepository.save(user);
    return user.getIdUser();
  }

  @Override
  public List<UserDto> get() {
    return userMapper.convertUserListToUserDto(userRepository.findAll());
  }

  @Override
  public UserDto get(String id) {
    return userMapper.userToDto(userRepository.findByIdUser(id));
  }

  @Override
  public void remove(String id) {
    userRepository.deleteById(id);
  }

  @Override
  public void update(UserDto userDto) throws DontExistsObjectInDatabaseException {
    User byIdUser = userRepository.findByIdUser(userDto.getIdUser());


    if (StringUtils.isNotEmpty(userDto.getFullName())) {
      byIdUser.setFullName(userDto.getFullName());
    }
    if (StringUtils.isNotEmpty(userDto.getPhoneNumber())) {
      byIdUser.setPhoneNumber(userDto.getPhoneNumber());
    }
    if (StringUtils.isNotEmpty(userDto.getPassword())) {
      byIdUser.setPassword(userDto.getPassword());
    }

    userRepository.save(byIdUser);

  }
}
