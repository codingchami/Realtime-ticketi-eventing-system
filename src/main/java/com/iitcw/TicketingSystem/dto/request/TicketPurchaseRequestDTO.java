package com.iitcw.TicketingSystem.dto.request;

import com.iitcw.TicketingSystem.entity.Customer;
import com.iitcw.TicketingSystem.entity.Ticket;

import java.util.Date;

public class TicketPurchaseRequestDTO {
    private int purchaseTicketID;
    private Date purchaseDate;
    private Customer customer;
    private Ticket ticket;

    public TicketPurchaseRequestDTO() {
    }

    public TicketPurchaseRequestDTO(int purchaseTicketID, Date purchaseDate, Customer customer, Ticket ticket) {
        this.purchaseTicketID = purchaseTicketID;
        this.purchaseDate = purchaseDate;
        this.customer = customer;
        this.ticket = ticket;
    }

    public int getPurchaseTicketID() {
        return purchaseTicketID;
    }

    public void setPurchaseTicketID(int purchaseTicketID) {
        this.purchaseTicketID = purchaseTicketID;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
