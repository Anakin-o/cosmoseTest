package com.didispace.controller;

import com.didispace.entity.Customer;
import com.didispace.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(description = "customer endpoint")
@RequestMapping("customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @ApiOperation(value = "register new customer" ,  notes="register new customer")
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody Customer customer) {
        customerService.register(customer);
    }

}