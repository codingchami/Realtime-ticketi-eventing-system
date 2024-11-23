package com.iitcw.TicketingSystem.service.impl;

import com.iitcw.TicketingSystem.dto.request.CustomerSaveRequestDTO;
import com.iitcw.TicketingSystem.entity.Customer;
import com.iitcw.TicketingSystem.repo.CustomerRepo;
import com.iitcw.TicketingSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerSaveRequestDTO saveRequestDTO) {

        Customer customer = new Customer(
                saveRequestDTO.getCustomerID(),
                saveRequestDTO.getCustomerName(),
                saveRequestDTO.getEmail(),
                saveRequestDTO.getContacts()
        );

        customerRepo.save(customer);
        return "saved";
    }
}
