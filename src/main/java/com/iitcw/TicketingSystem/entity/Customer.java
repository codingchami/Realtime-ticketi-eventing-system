package com.iitcw.TicketingSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id",length = 10)
    private int customerID;

    @Column(name = "customer_name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "customer_email",length = 50,nullable = false)
    private String email;
    @Column(name = "contacts",length = 10,nullable = false)
    private String contacts;

    public Customer() {
    }

    public Customer(int customerID, String customerName, String email, String contacts) {
        this.setCustomerID(customerID);
        this.setCustomerName(customerName);
        this.setEmail(email);
        this.setContacts(contacts);
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
