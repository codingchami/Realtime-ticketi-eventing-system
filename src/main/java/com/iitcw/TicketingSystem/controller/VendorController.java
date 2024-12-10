
package com.iitcw.TicketingSystem.controller;
import com.iitcw.TicketingSystem.dto.request.VendorSaveRequestDTO;
import com.iitcw.TicketingSystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("api/v1/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping(path = "/save-vendor")
    public String saveVendor(@RequestBody VendorSaveRequestDTO vendorSaveRequestDTO) {
        return vendorService.saveVendor(vendorSaveRequestDTO);
    }

    @PostMapping(path = "/start-vendor-thread/{vendorid}")
    public String startVendorThread(@PathVariable("vendorid") int vendorId) {
        return vendorService.startVendor(vendorId);
    }
}
