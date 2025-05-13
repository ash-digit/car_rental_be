package com.example.car_rental_back_end.services;

import com.example.car_rental_back_end.models.Customer;
import com.example.car_rental_back_end.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    public final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo){
        this.customerRepo = customerRepo;
    }

    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Customer with Id: %d was not found.", id)));
    }

    public void deleteCustomerById(Long id){
        customerRepo.deleteById(id);
    }
}
