package com.blinets.repository;

import com.blinets.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, String> {

  UserOrder findByIdOrder(String id);

}
