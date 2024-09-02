package com.streamlined.theraven.service;

import java.util.Optional;
import java.util.stream.Stream;

import com.streamlined.theraven.dto.CustomerDto;

public interface CustomerService {

	Stream<CustomerDto> getAllCustomers();
	
	Optional<CustomerDto> getCustomerById(Long id);
	
	CustomerDto save(CustomerDto customer);

}