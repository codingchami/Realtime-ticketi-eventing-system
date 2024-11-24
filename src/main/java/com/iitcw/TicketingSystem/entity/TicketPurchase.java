package com.iitcw.TicketingSystem.entity;

import com.iitcw.TicketingSystem.repo.TicketRepo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ticket_purchase")
public class TicketPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_id",length = 10)
    private int purchaseTicketID;
    @Column(name = "purchase_date",nullable = false)
    private Date purchaseDate;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public TicketPurchase() {
    }

    public TicketPurchase(int purchaseTicketID, Date purchaseDate, Customer customer, Ticket ticket) {
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
