package com.iitcw.TicketingSystem.service;

import com.iitcw.TicketingSystem.dto.request.VendorSaveRequestDTO;

public interface VendorService {
    String saveVendor(VendorSaveRequestDTO vendorSaveRequestDTO);
}
