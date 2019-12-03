package com.blinets.repository;

import com.blinets.entity.Maps;
import com.blinets.entity.Point;
import com.blinets.entity.User;
import com.blinets.entity.UserOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, String> {

  UserOrder findByIdOrder(String id);

  List<UserOrder> findByUser(User user);

  List<UserOrder>  findByStartIdPointOfRouteAndEndIdPointOfRoute(Point startIdPointOfRoute,
      Point endIdPointOfRoute);

}
