package org.trunghuynh.querrydemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trunghuynh.querrydemo.domain.entity.Customer;
import org.trunghuynh.querrydemo.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/search")
    public List<Customer> searchCustomer(@RequestParam("username") String username){
        return customerService.getCustomerListByUsername(username);
    }
}
