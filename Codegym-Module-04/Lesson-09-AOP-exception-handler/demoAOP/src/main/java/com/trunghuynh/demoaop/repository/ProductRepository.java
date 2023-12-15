package com.trunghuynh.demoaop.repository;


import com.trunghuynh.demoaop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
