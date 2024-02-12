package org.trunghuynh.querrydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.trunghuynh.querrydemo.domain.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from Customer where name like :username", nativeQuery = true)
    List<Customer> findCustomersByUsername(@Param("username") String username);
}
