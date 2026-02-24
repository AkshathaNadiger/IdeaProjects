package com.bank.app.service;

import com.bank.app.model.Customer;
import com.bank.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    @Override
    public String deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));
        customerRepository.delete((customer));
        return "Customer with customerId: " + customerId + " deleted Successfully";

     /*   if(!customerRepository.existsById(customerId)){
            throw new RuntimeException("Customer not found with id " +customerId);
        }
        customerRepository.deleteById(customerId);
    }*/
    }

    @Override
    public Customer updateCustomer(Customer updatedCustomer, Long customerId) {
        return customerRepository.findById(customerId)
                .map(existing -> {
                    existing.setFirstName(updatedCustomer.getFirstName());
                    existing.setLastName(updatedCustomer.getLastName());
                    existing.setEmail(updatedCustomer.getEmail());
                    existing.setPhoneNumber(updatedCustomer.getPhoneNumber());
                    return customerRepository.save(existing);


                })

                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + customerId));
    }


    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }


}
