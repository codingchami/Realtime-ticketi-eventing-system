package com.iitcw.TicketingSystem.thread;

import com.iitcw.TicketingSystem.dto.Systemconfigdto;
import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketPool {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private Systemconfigdto systemconfigdto;

    public synchronized void addTicket(Ticket ticket){
        if (ticket!=null) {
            System.out.println("Vendor added ticket with ID " + ticket.getTicketId() + " to the pool.");
        }if(ticketRepo.count() < systemconfigdto.getMaxTicketCapacity()) {
            System.out.println("Max ticket capacity reached. Cannot add more tickets.");
        }
    }

    public synchronized void removeTicket(int ticketId){
        Ticket ticket = ticketRepo.findById(ticketId).orElse(null);
        if (ticket != null) {
            ticket.setTicketStatus("PURCHASED");
            ticketRepo.save(ticket);
            System.out.println("=============================================================");
            System.out.println("Ticket with ID " + ticketId + " purchased and removed from the pool.");
        }
    }
}


