package com.blinets.repository;

import com.blinets.entity.Product;
import com.blinets.entity.UserOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByIdProduct(String idProduct);
    List<Product> findByUserOrder(UserOrder userOrder);
}