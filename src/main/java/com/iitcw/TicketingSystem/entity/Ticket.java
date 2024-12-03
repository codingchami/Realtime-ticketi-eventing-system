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

    @JoinColumn(name = "vendor_id",nullable = false)
    private int vendorId;
    @OneToMany(mappedBy = "ticket")
    private Set<TicketPurchase> ticketPurchases;

    public Ticket() {
    }


    public Ticket(int ticketId, String ticketName, String ticketStatus, double ticketPrice, int vendorId, Set<TicketPurchase> ticketPurchases) {
        this.setTicketId(ticketId);
        this.setTicketName(ticketName);
        this.setTicketStatus(ticketStatus);
        this.setTicketPrice(ticketPrice);
        this.setVendorId(vendorId);
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

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public Set<TicketPurchase> getTicketPurchases() {
        return ticketPurchases;
    }

    public void setTicketPurchases(Set<TicketPurchase> ticketPurchases) {
        this.ticketPurchases = ticketPurchases;
    }
}


