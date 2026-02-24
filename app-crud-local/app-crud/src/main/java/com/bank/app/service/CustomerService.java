package com.bank.app.service;

import com.bank.app.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomer();

    void createCustomer(Customer customer);

    String deleteCustomer(Long customerId);

    Customer updateCustomer(Customer customer, Long customerId);

    Optional<Customer> getCustomerById(Long id);
}
