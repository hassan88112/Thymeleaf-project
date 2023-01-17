package com.example.thymeleaf.Service;


import com.example.thymeleaf.Entity.Customer;
import com.example.thymeleaf.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> findAllCustomers() {
      return   customerRepo.findAll();
    }

    public Optional<Customer> findCustomerById(Long id) {
        return  customerRepo.findById(id);
    }

    public Customer addCustomer(Customer c) {

        return customerRepo.save(c);
    }

    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);
    }
}
