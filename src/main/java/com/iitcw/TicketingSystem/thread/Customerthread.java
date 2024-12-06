package com.iitcw.TicketingSystem.thread;

import com.iitcw.TicketingSystem.dto.Systemconfigdto;
import com.iitcw.TicketingSystem.entity.Customer;
import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.entity.TicketPurchase;
import com.iitcw.TicketingSystem.repo.CustomerRepo;
import com.iitcw.TicketingSystem.repo.TicketPurchaseRepo;
import com.iitcw.TicketingSystem.repo.TicketRepo;

import java.util.Date;


public class Customerthread implements Runnable{
    private final int customerId;
    private final int ticketId;
    private final TicketRepo ticketRepo;

    private final TicketPool ticketPool;
    private final Systemconfigdto systemConfig;
    private final TicketPurchaseRepo ticketPurchaseRepo;
    private final CustomerRepo customerRepo;

    public Customerthread(int customerId, int ticketId, TicketRepo ticketRepo, TicketPool ticketPool, Systemconfigdto systemConfig, TicketPurchaseRepo ticketPurchaseRepo,CustomerRepo customerRepo) {
        this.customerId = customerId;
        this.ticketId = ticketId;
        this.ticketRepo = ticketRepo;
        this.ticketPool = ticketPool;
        this.systemConfig = systemConfig;
        this.ticketPurchaseRepo = ticketPurchaseRepo;
        this.customerRepo = customerRepo;
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

        // Fetch the customer by ID (you should have a CustomerRepo for this)
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (customer == null) {
            return "Customer not found.";
        }

        TicketPurchase ticketPurchase = new TicketPurchase();

        ticketPurchase.setPurchaseDate(new Date());
        ticketPurchase.setCustomer(customer);
        ticketPurchase.setTicket(ticket);

        // Save the ticket purchase details to the database
        ticketPurchaseRepo.save(ticketPurchase);

        ticketPool.removeTicket(ticketId);

       return "Ticket purchased successfully by customer " + customerId;
    }
}




