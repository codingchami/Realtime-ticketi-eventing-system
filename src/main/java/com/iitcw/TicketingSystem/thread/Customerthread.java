package com.iitcw.TicketingSystem.thread;

import com.iitcw.TicketingSystem.dto.request.TicketPurchaseRequestDTO;
import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.entity.TicketPurchase;
import com.iitcw.TicketingSystem.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Customerthread implements Runnable{

    private int customerId;
    private int ticketId;
    private TicketRepo ticketRepo;
    private TicketPool ticketPool;

//    private final TicketPurchase ticketPurchase;
//    private final TicketRepo ticketRepo;
//
//    private final TicketPool ticketPool;
//
//    private final TicketPurchaseRequestDTO ticketPurchaseRequestDTO;


//    @Autowired
//    private TicketRepo ticketRepo;
//
//    @Autowired
//    private TicketPool ticketPool;


//    public Customerthread(TicketPurchase ticketPurchase, TicketRepo ticketRepo, TicketPool ticketPool, TicketPurchaseRequestDTO ticketPurchaseRequestDTO) {
//        this.ticketPurchase = ticketPurchase;
//        this.ticketRepo = ticketRepo;
//        this.ticketPool = ticketPool;
//        this.ticketPurchaseRequestDTO = ticketPurchaseRequestDTO;
//    }
//
//    public Customerthread(int purchaseTicketID, int purchaseTicketID1, TicketPurchase ticketPurchase, TicketRepo ticketRepo, TicketPool ticketPool, TicketPurchaseRequestDTO ticketPurchaseRequestDTO) {
//        this.ticketPurchase = ticketPurchase;
//        this.ticketRepo = ticketRepo;
//        this.ticketPool = ticketPool;
//        this.ticketPurchaseRequestDTO = ticketPurchaseRequestDTO;
//    }


    public Customerthread(int customerId, int ticketId, TicketRepo ticketRepo, TicketPool ticketPool) {
        this.customerId = customerId;
        this.ticketId = ticketId;
        this.ticketRepo = ticketRepo;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        try {
            // Call purchaseTicket method to handle ticket purchase
            String result = purchaseTicket(ticketId,customerId);
            System.out.println(result);  // Output result
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String purchaseTicket(int ticketId, int customerId) {
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




