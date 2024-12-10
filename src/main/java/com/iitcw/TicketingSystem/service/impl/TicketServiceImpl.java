package com.iitcw.TicketingSystem.service.impl;

import com.iitcw.TicketingSystem.dto.response.AllTicketDeatailsResponseDTO;
import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.repo.TicketRepo;
import com.iitcw.TicketingSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;
    @Override
    public List<AllTicketDeatailsResponseDTO> getAllTicketsByStatus(String ticketStatus) {
        List<Ticket> tickets = ticketRepo.findByTicketStatus(ticketStatus);
        return tickets.stream()
                .map(ticket -> new AllTicketDeatailsResponseDTO(
                        ticket.getTicketId(),
                        ticket.getTicketName(),
                        ticket.getTicketStatus(),
                        ticket.getTicketPrice()))
                .collect(Collectors.toList());
    }
}
