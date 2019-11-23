package com.blinets.repository;

import com.blinets.entity.Maps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapsRepository extends JpaRepository<Maps, String> {

  Maps findByIdMaps(String id);
}