package com.trunghuynh.demorestful.repository;

import com.trunghuynh.demorestful.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository  extends PagingAndSortingRepository<Customer, Long> {
}
