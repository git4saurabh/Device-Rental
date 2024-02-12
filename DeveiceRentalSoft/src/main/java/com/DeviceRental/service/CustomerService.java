package com.DeviceRental.service;

import com.DeviceRental.model.Customer;
import com.DeviceRental.repository.CustomerRepository;
import org.springframework.stereotype.Service;

//package com.example.devicerentalservice.service;


import org.springframework.beans.factory.annotation.Autowired;
;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public Optional<Customer> getCustomerByEmail(String email) {
        return Optional.ofNullable(customerRepository.findByEmail(email));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    // Add more methods as needed
}

