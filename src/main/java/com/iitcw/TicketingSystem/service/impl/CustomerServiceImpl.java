package com.iitcw.TicketingSystem.service.impl;

import com.iitcw.TicketingSystem.dto.request.CustomerSaveRequestDTO;
import com.iitcw.TicketingSystem.dto.response.CustomerResponseDTO;
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

    @Override
    public String updateCustomer(CustomerSaveRequestDTO requestDTO) {
        if (customerRepo.existsById(requestDTO.getCustomerID())){
            Customer customer = customerRepo.getReferenceById(requestDTO.getCustomerID());

            customer.setCustomerID(requestDTO.getCustomerID());
            customer.setCustomerName(requestDTO.getCustomerName());
            customer.setEmail(requestDTO.getEmail());
            customer.setContacts(requestDTO.getContacts());

            customerRepo.save(customer);
            return requestDTO.getCustomerName() + "has been updated...!";
        }else{
            return "something went wrong...!";
        }
    }

    @Override
    public CustomerResponseDTO getCustomerById(int customerID) {
        if(customerRepo.existsById(customerID)){
            Customer customer = customerRepo.getReferenceById(customerID);

            return new CustomerResponseDTO(
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getEmail(),
                    customer.getContacts()
            );

        }else{
            return null;
        }
    }

    @Override
    public String deleteCustomer(int customerID) {
        if(customerRepo.existsById(customerID)){
            customerRepo.deleteById(customerID);
            return customerID+" Customer has been deleted...!";
        }else{
            return "Customer is not found!.........";
        }
    }

}
