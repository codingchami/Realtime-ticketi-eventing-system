package com.iitcw.TicketingSystem.thread;

import com.iitcw.TicketingSystem.dto.Systemconfigdto;
import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vendorthread implements Runnable{

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private TicketPool ticketPool;

    @Autowired
    private Systemconfigdto systemconfigdto;

    public Vendorthread(TicketPool ticketPool, Systemconfigdto systemconfigdto) {
        this.ticketPool = ticketPool;
        this.systemconfigdto = systemconfigdto;
    }

    @Override
    public void run() {

        // Simulate the vendor adding tickets to the pool at the defined rate
        for (int i = 0; i < systemconfigdto.getTotalNumberofTickets(); i++) {
            Ticket ticket = new Ticket();
            ticket.setTicketId(i + 1);  // Assign a unique ticket ID
            ticket.setTicketName("Ticket " + (i + 1));
            ticket.setTicketStatus("AVAILABLE");  // Initially set the status to AVAILABLE

            // Add the ticket to the pool
            ticketPool.addTicket(ticket);

            try {
                Thread.sleep(systemconfigdto.getTicketReleaseRate());  // Wait before releasing next ticket
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
