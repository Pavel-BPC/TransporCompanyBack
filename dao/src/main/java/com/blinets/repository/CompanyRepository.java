package com.blinets.repository;

import com.blinets.entity.Company;
import com.blinets.entity.Maps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}