package com.trunghuynh.services;

import com.trunghuynh.model.Customer;

import java.util.List;

public interface ICustomerServices {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
