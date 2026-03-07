package com.finflow.customer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerModel {

	private String name;

	private String email;
}