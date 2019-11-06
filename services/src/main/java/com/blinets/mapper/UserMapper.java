package com.blinets.mapper;

import com.blinets.dto.UserDto;
import com.blinets.entity.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {

  UserDto userToDto(User user);

  User dtoToUser(UserDto userDto);

  List<User> convertUserDTOListToUserList(List<UserDto> userDtoList);

  List<UserDto> convertUserListToUserDto(List<User> users);
}