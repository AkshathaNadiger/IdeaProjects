package com.bank.app.controller;

import com.bank.app.model.Customer;
import com.bank.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {

        return customerService.getCustomerById(id)
                .map(customer -> ResponseEntity.ok(customer))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }


    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>("Customer Added Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId) {
        try {
            String status = customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

/*    @PutMapping("/{id}")
    public  ResponseEntity<String> updateCustomer(@PathVariable(name ="id") Long customerId, @RequestBody Customer customer) {
        try {
            return ResponseEntity.ok(customerService.updateCustomer(customerId, customer));

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @RequestBody Customer customer,
            @PathVariable(name = "id") Long customerId) {

        try {
            Customer savedCustomer = customerService.updateCustomer(customer, customerId);
            return ResponseEntity.ok(savedCustomer);

        } catch (ResponseStatusException e) {
            throw e;  // cleaner approach
        }
    }
}

