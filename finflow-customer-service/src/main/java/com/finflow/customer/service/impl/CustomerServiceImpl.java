package com.finflow.customer.service.impl;

import com.finflow.customer.entity.Customer;
import com.finflow.customer.repository.CustomerRepository;
import com.finflow.customer.service.CustomerService;
import com.finflow.platform.exception.PlatformException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer request) {

		Customer customer = Customer.builder().name(request.getName()).email(request.getEmail()).build();

		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(Long id) {

		return customerRepository.findById(id)
				.orElseThrow(() -> new PlatformException("CUSTOMER_NOT_FOUND", "Customer not found"));
	}
}