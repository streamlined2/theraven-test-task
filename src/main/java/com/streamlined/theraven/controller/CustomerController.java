package com.streamlined.theraven.controller;

import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streamlined.theraven.dto.CustomerDto;
import com.streamlined.theraven.service.CustomerService;
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

}
