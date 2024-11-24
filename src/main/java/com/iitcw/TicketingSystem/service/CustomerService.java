package com.iitcw.TicketingSystem.service;

import com.iitcw.TicketingSystem.dto.request.CustomerSaveRequestDTO;
import com.iitcw.TicketingSystem.dto.response.CustomerResponseDTO;

public interface CustomerService {
    String saveCustomer(CustomerSaveRequestDTO saveRequestDTO);

    String updateCustomer(CustomerSaveRequestDTO requestDTO);

    CustomerResponseDTO getCustomerById(int customerID);

    String deleteCustomer(int customerID);
}
