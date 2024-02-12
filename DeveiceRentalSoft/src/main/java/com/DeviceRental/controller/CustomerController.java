package com.DeviceRental.controller;

import com.DeviceRental.model.Customer;
import com.DeviceRental.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
//


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/{customerId}")
    public String getCustomerById(@PathVariable Long customerId, Model model) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer.orElse(null));
        return "customer-details";
    }

    @GetMapping("/create")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/update/{customerId}")
    public String updateCustomerForm(@PathVariable Long customerId, Model model) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer.orElse(null));
        return "customer-update";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customers";
    }
}

