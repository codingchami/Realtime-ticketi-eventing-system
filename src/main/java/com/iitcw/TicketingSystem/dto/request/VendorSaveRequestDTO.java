package com.iitcw.TicketingSystem.dto.request;

public class VendorSaveRequestDTO {
    private int vendorID;
    private String vendorName;
    private String email;

    public VendorSaveRequestDTO() {}

    public VendorSaveRequestDTO(int vendorID, String vendorName, String email) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.email = email;
    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
