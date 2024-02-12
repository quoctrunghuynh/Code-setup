package org.trunghuynh.querrydemo.service;

import org.trunghuynh.querrydemo.domain.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomerListByUsername(String username);
}
