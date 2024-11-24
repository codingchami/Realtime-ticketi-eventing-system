package com.iitcw.TicketingSystem.controller;

import com.iitcw.TicketingSystem.dto.request.TicketSaveRequestDTO;
import com.iitcw.TicketingSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping(
            path = "/ticket-purcahse",
            params = {"ticket_id","customer_id"}
    )

    public String purchaseTicket(@RequestParam(name = "ticket_id")int ticket_id,
                                 @RequestParam(name = "customer_id") int customer_id){

        String message = ticketService.purchaseTicket(ticket_id,customer_id);
        return message;
    }
}
