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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

@Log4j2
@Service
public class UserServices implements CrudService<UserDto> {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @Autowired
  public UserServices(UserRepository userRepository,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public String create(UserDto userDto )
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    User user = userMapper.dtoToUser(userDto);
    user.setIdUser(UUID.randomUUID().toString());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRoles(userDto.getRoles());
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

    //TODO
    if (StringUtils.isNotEmpty(userDto.getName())) {
      byIdUser.setName(userDto.getName());
    }
    if (StringUtils.isNotEmpty(userDto.getLastName())) {
      byIdUser.setLastName(userDto.getLastName());
    }
    //TODO
    if (StringUtils.isNotEmpty(userDto.getPhoneNumber())) {
      byIdUser.setPhoneNumber(userDto.getPhoneNumber());
    }
    if (StringUtils.isNotEmpty(userDto.getPassword())) {
      byIdUser.setPassword(userDto.getPassword());
    }

    userRepository.save(byIdUser);

  }
}
