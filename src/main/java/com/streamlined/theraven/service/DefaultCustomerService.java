package com.streamlined.theraven.service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.streamlined.theraven.dao.CustomerRepository;
import com.streamlined.theraven.dto.CustomerDto;
import com.streamlined.theraven.dto.mapper.CustomerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultCustomerService implements CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	@Override
	public Stream<CustomerDto> getAllCustomers() {
		return customerRepository.findAll().stream().map(customerMapper::toDto);
	}

}
