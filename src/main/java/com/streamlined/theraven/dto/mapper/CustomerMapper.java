package com.streamlined.theraven.dto.mapper;

import org.springframework.stereotype.Component;

import com.streamlined.theraven.data.Customer;
import com.streamlined.theraven.dto.CustomerDto;

@Component
public class CustomerMapper {

	public CustomerDto toDto(Customer customer) {
		return CustomerDto.builder().id(customer.getId()).fullName(customer.getFullName()).email(customer.getEmail())
				.phone(customer.getPhone()).build();
	}

	public Customer toEntity(CustomerDto customer) {
		return Customer.builder().id(customer.id()).fullName(customer.fullName()).email(customer.email())
				.phone(customer.phone()).isActive(true).build();
	}

}
