package com.iitcw.TicketingSystem.controller;

import com.iitcw.TicketingSystem.dto.request.VendorSaveRequestDTO;
import com.iitcw.TicketingSystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping(path = "/save-vendor")
    public String saveVendor(@RequestBody VendorSaveRequestDTO vendorSaveRequestDTO){
        String message = vendorService.saveVendor(vendorSaveRequestDTO);
        return message;
    }
}