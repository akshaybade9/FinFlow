package com.finflow.customer.controller;


import com.finflow.customer.entity.Customer;
import com.finflow.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer request) {
        return customerService.createCustomer(request);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
    	 log.debug("Fetching customer");
        return customerService.getCustomer(id);
    }
}