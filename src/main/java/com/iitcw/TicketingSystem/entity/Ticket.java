package com.iitcw.TicketingSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id",length = 10)
    private int ticketId;
    @Column(name = "ticket_name")
    private String ticketName;

    public Ticket() {
    }
    @ManyToOne
    @JoinColumn(name = "vendor_id",nullable = false)
    private Vendor vendor;
    public Ticket(int ticketId, String ticketName) {
        this.setTicketId(ticketId);
        this.setTicketName(ticketName);
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
}
