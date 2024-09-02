package com.streamlined.theraven.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.streamlined.theraven.dao.CustomerRepository;
import com.streamlined.theraven.data.Customer;
import com.streamlined.theraven.dto.CustomerDto;
import com.streamlined.theraven.dto.mapper.CustomerMapper;
import com.streamlined.theraven.exception.EntityNotFoundException;

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
	public Optional<CustomerDto> getCustomerById(Long id) {
		return customerRepository.findById(id).map(customerMapper::toDto);
	}

	@Override
	@Transactional
	public CustomerDto save(CustomerDto dto) {
		Customer entity = customerMapper.toEntity(dto);
		Utilities.checkIfValid(validator, entity, "customer");
		return customerMapper.toDto(customerRepository.save(entity));
	}

	@Override
	@Transactional
	public CustomerDto save(Long id, CustomerDto dto) {
		Customer entity = customerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found for id %d".formatted(id)));
		entity.setFullName(dto.fullName());
		entity.setEmail(dto.email());
		entity.setPhone(dto.phone());
		Utilities.checkIfValid(validator, entity, "customer");
		return customerMapper.toDto(customerRepository.save(entity));
	}

}
