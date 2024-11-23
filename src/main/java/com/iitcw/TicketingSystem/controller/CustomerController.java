package com.iitcw.TicketingSystem.controller;

import com.iitcw.TicketingSystem.dto.request.CustomerSaveRequestDTO;
import com.iitcw.TicketingSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;  //property dependent injection

    @PostMapping(path = "/save-customer")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO saveRequestDTO){
        String message = customerService.saveCustomer(saveRequestDTO);
        return message;
    }

}
