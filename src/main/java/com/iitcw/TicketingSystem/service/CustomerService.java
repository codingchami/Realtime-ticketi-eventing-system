package com.iitcw.TicketingSystem.service;

import com.iitcw.TicketingSystem.dto.request.CustomerSaveRequestDTO;

public interface CustomerService {
    String saveCustomer(CustomerSaveRequestDTO saveRequestDTO);
}
