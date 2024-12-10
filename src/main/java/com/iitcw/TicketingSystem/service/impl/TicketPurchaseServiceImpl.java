package com.iitcw.TicketingSystem.service.impl;//package com.iitcw.TicketingSystem.service.impl;

import com.iitcw.TicketingSystem.Advisor.TicketPurchaseNotFoundException;
import com.iitcw.TicketingSystem.dto.response.TicketPurchaseResponseDTO;
import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.entity.TicketPurchase;
import com.iitcw.TicketingSystem.repo.TicketPurchaseRepo;
import com.iitcw.TicketingSystem.service.TicketPurchaseService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TicketPurchaseServiceImpl implements TicketPurchaseService {
    @Autowired
    private TicketPurchaseRepo ticketPurchaseRepo;


    @Override
    public List<TicketPurchaseResponseDTO> getAllPurchaseTickets() {
        List<TicketPurchase> ticketPurchases = ticketPurchaseRepo.findAll();

        List<TicketPurchaseResponseDTO> responseDTOS = new ArrayList<>();

        if (!ticketPurchases.isEmpty()) {
            for(TicketPurchase ticketPurchase: ticketPurchases){
                responseDTOS.add(new TicketPurchaseResponseDTO(
                        ticketPurchase.getPurchaseTicketID(),
                        ticketPurchase.getPurchaseDate(),
                        ticketPurchase.getCustomer(),
                        ticketPurchase.getTicket()
                ));
            }

        }
        return responseDTOS;
    }

}
