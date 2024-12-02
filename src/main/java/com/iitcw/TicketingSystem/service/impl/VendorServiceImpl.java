package com.iitcw.TicketingSystem.service.impl;

import com.iitcw.TicketingSystem.dto.request.VendorSaveRequestDTO;
import com.iitcw.TicketingSystem.entity.Vendor;
import com.iitcw.TicketingSystem.repo.VendorRepo;
import com.iitcw.TicketingSystem.service.VendorService;
import com.iitcw.TicketingSystem.thread.Customerthread;
import com.iitcw.TicketingSystem.thread.Vendorthread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepo vendorRepo;

    private Vendorthread vendorthread;

    @Override
    public String saveVendor(VendorSaveRequestDTO vendorSaveRequestDTO) {
        Vendor vendor = new Vendor(
                vendorSaveRequestDTO.getVendorID(),
                vendorSaveRequestDTO.getVendorName(),
                vendorSaveRequestDTO.getEmail()
        );

        vendorRepo.save(vendor);
        return "vendor saved";
    }

    @Override
    public String startVendor(int vendorId) {

        Vendorthread vendorthread = new Vendorthread(vendorId);  // Manually pass the vendorId here
        Thread thread = new Thread(vendorthread);
        thread.start();
        return "Vendor thread started successfully!";
    }
}
