package com.iitcw.TicketingSystem.dto.request;

import com.iitcw.TicketingSystem.entity.TicketPurchase;
import com.iitcw.TicketingSystem.entity.Vendor;


import java.util.Set;

public class TicketDTO {
    private int ticketId;

    private String ticketName;

    private String ticketStatus;

    private double ticketPrice;

    private Vendor vendor;

    private Set<TicketPurchase> ticketPurchases;

    public TicketDTO() {
    }

    public TicketDTO(String ticketName, String ticketStatus, double ticketPrice, Vendor vendor, Set<TicketPurchase> ticketPurchases) {
        this.ticketName = ticketName;
        this.ticketStatus = ticketStatus;
        this.ticketPrice = ticketPrice;
        this.vendor = vendor;
        this.ticketPurchases = ticketPurchases;
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
