package com.finflow.customer.service;

import com.finflow.customer.entity.Customer;

public interface CustomerService {

    Customer createCustomer(Customer request);

    Customer getCustomer(Long id);
}