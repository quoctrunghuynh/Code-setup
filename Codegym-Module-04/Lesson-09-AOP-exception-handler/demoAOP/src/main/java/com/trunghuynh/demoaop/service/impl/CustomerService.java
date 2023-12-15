package com.trunghuynh.demoaop.service.impl;


import com.trunghuynh.demoaop.model.Customer;
import com.trunghuynh.demoaop.repository.CustomerRepository;
import com.trunghuynh.demoaop.service.GeneralService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService implements GeneralService<Customer> {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid argument!"));
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
        customerRepository.flush();
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
