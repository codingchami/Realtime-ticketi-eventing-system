package com.iitcw.TicketingSystem.service.impl;

import com.iitcw.TicketingSystem.dto.request.VendorSaveRequestDTO;
import com.iitcw.TicketingSystem.entity.Vendor;
import com.iitcw.TicketingSystem.repo.VendorRepo;
import com.iitcw.TicketingSystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepo vendorRepo;

    @Override
    public String saveVendor(VendorSaveRequestDTO vendorSaveRequestDTO) {
        Vendor vendor = new Vendor(
                vendorSaveRequestDTO.getVendorID(),
                vendorSaveRequestDTO.getVendorName(),
                vendorSaveRequestDTO.getEmail()
        );

        vendorRepo.save(vendor);
        return "saved";
    }
}
