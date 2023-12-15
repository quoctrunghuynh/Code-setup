package com.trunghuynh.demoaop.repository;


import com.trunghuynh.demoaop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
