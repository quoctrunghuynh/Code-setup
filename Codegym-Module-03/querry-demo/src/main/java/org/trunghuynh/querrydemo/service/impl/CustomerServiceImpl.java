package org.trunghuynh.querrydemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.trunghuynh.querrydemo.domain.entity.Customer;
import org.trunghuynh.querrydemo.repository.CustomerRepository;
import org.trunghuynh.querrydemo.service.CustomerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomerListByUsername(String username) {
        return customerRepository.findCustomersByUsername(username);
    }
}
