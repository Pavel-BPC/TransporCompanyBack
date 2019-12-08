package com.blinets.repository;

import com.blinets.entity.Company;
import com.blinets.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, String> {
    Point findByIdPoint(String id);


    void removeByIdPoint(String id);


}