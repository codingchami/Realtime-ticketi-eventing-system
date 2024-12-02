package com.iitcw.TicketingSystem.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id",length = 10)
    private int ticketId;

    @Column(name = "ticket_name")
    private String ticketName;

    @Column(name = "ticket_status")
    private String ticketStatus;
    @Column(name = "ticket_price")
    private double ticketPrice;

    @ManyToOne
    @JoinColumn(name = "vendor_id",nullable = false)
    private Vendor vendor;
    @OneToMany(mappedBy = "ticket")
    private Set<TicketPurchase> ticketPurchases;

    public Ticket() {
    }

    public Ticket(int ticketId, String ticketName, String ticketStatus, Vendor vendor, Set<TicketPurchase> ticketPurchases) {
        this.setTicketId(ticketId);
        this.setTicketName(ticketName);
        this.setTicketStatus(ticketStatus);
        this.setVendor(vendor);
        this.setTicketPurchases(ticketPurchases);
    }

    public Ticket(int ticketId, String ticketName, String ticketStatus, double ticketPrice, Vendor vendor, Set<TicketPurchase> ticketPurchases) {
        this.setTicketId(ticketId);
        this.setTicketName(ticketName);
        this.setTicketStatus(ticketStatus);
        this.setTicketPrice(ticketPrice);
        this.setVendor(vendor);
        this.setTicketPurchases(ticketPurchases);
    }


    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Set<TicketPurchase> getTicketPurchases() {
        return ticketPurchases;
    }

    public void setTicketPurchases(Set<TicketPurchase> ticketPurchases) {
        this.ticketPurchases = ticketPurchases;
    }
}
