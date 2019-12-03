package com.blinets.repository;

import com.blinets.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, String> {

  Transport findByIdTransport(String id);

  void deleteByIdTransport(String id);
}