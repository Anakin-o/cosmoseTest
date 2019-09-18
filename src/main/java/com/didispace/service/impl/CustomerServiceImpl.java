package com.didispace.service.impl;

import com.didispace.entity.Customer;
import com.didispace.entity.Room;
import com.didispace.model.RoomSearchCriteria;
import com.didispace.repository.CustomerRepository;
import com.didispace.repository.ReservationRepository;
import com.didispace.repository.RoomRepository;
import com.didispace.service.CustomerService;
import com.didispace.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void register(Customer customer) {
        customerRepository.save(customer);
    }
}
