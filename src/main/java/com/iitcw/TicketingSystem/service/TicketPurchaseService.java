package com.iitcw.TicketingSystem.service;

import com.iitcw.TicketingSystem.dto.response.TicketPurchaseResponseDTO;

import java.util.List;

public interface TicketPurchaseService {

    List<TicketPurchaseResponseDTO> getAllPurchaseTickets();
}
