package com.iitcw.TicketingSystem.dto.request;

import javax.persistence.Column;

public class CustomerSaveRequestDTO {

    private int customerID;
    private String customerName;
    private String email;
    private String contacts;

    public CustomerSaveRequestDTO() {
    }

    public CustomerSaveRequestDTO(int customerID, String customerName, String email, String contacts) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
        this.contacts = contacts;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
