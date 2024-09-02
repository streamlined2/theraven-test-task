package com.streamlined.theraven.service;

import java.util.stream.Stream;

import com.streamlined.theraven.dto.CustomerDto;

public interface CustomerService {

	Stream<CustomerDto> getAllCustomers();
	
	CustomerDto save(CustomerDto customer);

}