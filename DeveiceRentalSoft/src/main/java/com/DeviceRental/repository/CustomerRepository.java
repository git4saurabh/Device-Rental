package com.DeviceRental.repository;

import com.DeviceRental.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query to find a customer by email
    Customer findByEmail(String email);
}
