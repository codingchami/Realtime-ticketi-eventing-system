package com.iitcw.TicketingSystem.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vendor_id",length = 10)
    private int vendorID;

    @Column(name = "vendor_name",length = 100,nullable = false)
    private String vendorName;

    @Column(name = "vendor_email",length = 50,nullable = false)
    private String email;
    @OneToMany(mappedBy = "vendor")
    private Set<Ticket> tickets;
    public Vendor() {
    }

    public Vendor(int vendorID, String vendorName, String email) {
        this.setVendorID(vendorID);
        this.setVendorName(vendorName);
        this.setEmail(email);
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
