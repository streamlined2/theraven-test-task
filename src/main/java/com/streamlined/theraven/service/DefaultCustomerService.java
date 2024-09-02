package com.streamlined.theraven.service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.streamlined.theraven.dao.CustomerRepository;
import com.streamlined.theraven.data.Customer;
import com.streamlined.theraven.dto.CustomerDto;
import com.streamlined.theraven.dto.mapper.CustomerMapper;

import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultCustomerService implements CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	private final Validator validator;

	@Override
	public Stream<CustomerDto> getAllCustomers() {
		return Utilities.stream(customerRepository.findAll()).map(customerMapper::toDto);
	}

	@Override
	@Transactional
	public CustomerDto save(CustomerDto dto) {
		Customer entity = customerMapper.toEntity(dto);
		Utilities.checkIfValid(validator, entity, "customer");
		return customerMapper.toDto(customerRepository.save(entity));
	}

}
