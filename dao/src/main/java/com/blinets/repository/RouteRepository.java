package com.blinets.repository;

import com.blinets.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {

  Route findByIdRoute(String id);

}