//package com.iitcw.TicketingSystem.service.impl;

import com.iitcw.TicketingSystem.dto.response.TicketPurchaseResponseDTO;
import com.iitcw.TicketingSystem.entity.TicketPurchase;
import com.iitcw.TicketingSystem.repo.TicketPurchaseRepo;
import com.iitcw.TicketingSystem.service.TicketPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TicketPurchaseServiceImpl implements TicketPurchaseService {
    @Autowired
    private TicketPurchaseRepo ticketPurchaseRepo;

    @Override
    public List<TicketPurchaseResponseDTO> getAllPurchaseTickets() {
        List<TicketPurchase> purchases = ticketPurchaseRepo.findAll();

    }

}
