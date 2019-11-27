package com.blinets.mapper;

import com.blinets.dto.UserDto;
import com.blinets.dto.UserOrderDto;
import com.blinets.entity.User;
import com.blinets.entity.UserOrder;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface UserOrderMapper {

  UserOrderDto UserOrderToDto(UserOrder userOrder);

  UserOrder dtoToUserOrder(UserOrderDto userOrderDto);

  List<UserOrder> convertUserOrderDTOTOListToUserOrderList(List<UserOrderDto> userOrderDtos);

  List<UserOrderDto> convertUserOrderListToUserOrderDto(List<UserOrder> userOrders);
}