package com.streamlined.theraven.controller;

import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streamlined.theraven.dto.CustomerDto;
import com.streamlined.theraven.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerService customerService;

	@GetMapping
	public Stream<CustomerDto> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@PostMapping
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto dto, HttpServletRequest servletRequest) {
		CustomerDto savedCustomerDto = customerService.save(dto);
		return ResponseEntity.created(Utilities.getResourceURI(servletRequest, savedCustomerDto.id()))
				.body(savedCustomerDto);
	}

}
