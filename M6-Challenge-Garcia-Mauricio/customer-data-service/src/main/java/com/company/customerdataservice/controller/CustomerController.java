package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    // A POST route that creates a new customer.
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer newCustomer(@RequestBody Customer c) {
        return repo.save(c);
    }

    // A PUT route that updates an existing customer.
    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@RequestBody Customer c) {
        repo.save(c);
    }

    // A DELETE route that deletes an existing customer.
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }

    // A GET route that returns a specific customer by id.
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerID(@PathVariable int id) {
        Optional<Customer> c = repo.findById(id);
        if(c.isEmpty()) { // if empty then return null
            return null;
        }else { // customer not empty, so it was found
            return c.get();
        }
    }

    // A GET route that returns all customers for a specific state.
    @GetMapping("customers/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomerState(@PathVariable String state){
        return repo.findByState(state);
    }

}
