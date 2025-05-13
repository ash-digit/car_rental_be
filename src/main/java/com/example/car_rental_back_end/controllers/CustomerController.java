package com.example.car_rental_back_end.controllers;

import com.example.car_rental_back_end.models.Customer;
import com.example.car_rental_back_end.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Create
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    //Read

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
        return String.format("Customer with Id: %d has been deleted", id);
    }
}
