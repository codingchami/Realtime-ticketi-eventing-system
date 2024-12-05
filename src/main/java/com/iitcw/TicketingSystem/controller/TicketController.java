package com.iitcw.TicketingSystem.controller;

import com.iitcw.TicketingSystem.dto.Systemconfigdto;
import com.iitcw.TicketingSystem.dto.request.TicketPurchaseRequestDTO;
import com.iitcw.TicketingSystem.repo.TicketRepo;
//import com.iitcw.TicketingSystem.thread.Customerthread;
import com.iitcw.TicketingSystem.thread.Customerthread;
import com.iitcw.TicketingSystem.thread.TicketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@CrossOrigin
@RequestMapping("api/v1/ticket")
public class TicketController {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private TicketPool ticketPool;

    @Autowired
    private Systemconfigdto systemConfig;

    private TicketPurchaseRequestDTO ticketPurchaseRequestDTO;

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @PostMapping(
            path = "/ticket-purcahse",
            params = {"ticket_id","customer_id"}
    )

    public String purchaseTicket(@RequestParam(name = "ticket_id")int ticket_id,
                                 @RequestParam(name = "customer_id") int customer_id){



        // Create a new CustomerThread to handle ticket purchase
        Customerthread customerThread = new Customerthread(ticket_id,customer_id,ticketRepo,ticketPool,systemConfig);
        executorService.execute(customerThread);

//        Thread thread = new Thread(customerThread);
//        thread.start();  // Start the thread to simulate ticket purchase

        return "Ticket purchase request is being processed.";

    }
}
