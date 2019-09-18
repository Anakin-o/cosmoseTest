package com.didispace.service.impl;

import com.didispace.entity.Customer;
import com.didispace.repository.CustomerRepository;
import com.didispace.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void register(Customer customer) {
        customerRepository.save(customer);
    }
}
