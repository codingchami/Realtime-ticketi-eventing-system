package com.iitcw.TicketingSystem.thread;

import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customerthread implements Runnable{

    private int customerId;
    private int ticketId;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private TicketPool ticketPool;

    public Customerthread(int customerId, int ticketId) {
        this.customerId = customerId;
        this.ticketId = ticketId;
    }

    @Override
    public void run() {
        try {
            // Call purchaseTicket method to handle ticket purchase
            String result = purchaseTicket(ticketId, customerId);
            System.out.println(result);  // Output result
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String purchaseTicket(int ticketId, int customerId) {
        // Fetch ticket from the database by ID
        Ticket ticket = ticketRepo.findById(ticketId).orElse(null);
        if (ticket == null) {
            return "Ticket not found.";
        }

        // Check if the ticket is available
        if (!"AVAILABLE".equals(ticket.getTicketStatus())) {
            return "Ticket is not available for purchase.";
        }

        // Remove the ticket from the pool (simulate the purchase)
        ticketPool.removeTicket(ticketId);

        // Return success message
        return "Ticket purchased successfully by customer " + customerId;
    }
}




