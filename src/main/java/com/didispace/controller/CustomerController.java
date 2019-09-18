package com.didispace.controller;

import com.didispace.entity.Customer;
import com.didispace.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void searchReservation(@RequestBody Customer customer) {
        customerService.register(customer);
    }

}