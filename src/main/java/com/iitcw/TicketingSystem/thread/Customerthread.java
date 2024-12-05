package com.iitcw.TicketingSystem.thread;

import com.iitcw.TicketingSystem.dto.Systemconfigdto;
import com.iitcw.TicketingSystem.dto.request.TicketPurchaseRequestDTO;
import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.entity.TicketPurchase;
import com.iitcw.TicketingSystem.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Customerthread implements Runnable{
    private final int customerId;
    private final int ticketId;
    private final TicketRepo ticketRepo;

    private final TicketPool ticketPool;
    private final Systemconfigdto systemConfig;

    public Customerthread(int customerId, int ticketId, TicketRepo ticketRepo, TicketPool ticketPool, Systemconfigdto systemConfig) {
        this.customerId = customerId;
        this.ticketId = ticketId;
        this.ticketRepo = ticketRepo;
        this.ticketPool = ticketPool;
        this.systemConfig = systemConfig;
    }

    @Override
    public void run() {
        try {
            // Call purchaseTicket method to handle ticket purchase
            String result = purchaseTicket(ticketId,customerId);
            try {
                Thread.sleep(systemConfig.getCustomerRetrieverRate());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(result);  // Output result

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String purchaseTicket(int customerId,int ticketId) {
        System.out.println("===========================================");
        System.out.println("Searching for ticket with ID: " + ticketId);
        System.out.println("===========================================");

        Ticket ticket = ticketRepo.findById(ticketId).orElse(null);
        if (ticket == null) {
            return "Ticket not found.";
        }

        if (!"AVAILABLE".equals(ticket.getTicketStatus())) {
            return "Ticket is not available for purchase.";
        }

        ticketPool.removeTicket(ticketId);

       return "Ticket purchased successfully by customer " + customerId;
    }
}




