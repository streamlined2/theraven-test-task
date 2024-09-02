package com.streamlined.theraven.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.streamlined.theraven.data.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
