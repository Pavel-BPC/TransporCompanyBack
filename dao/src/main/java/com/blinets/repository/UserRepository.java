package com.blinets.repository;

import com.blinets.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  User findByLoginEmail(String login);

  User findByIdUser(String id);

}
