package com.iitcw.TicketingSystem.service;

import com.iitcw.TicketingSystem.dto.response.AllTicketDeatailsResponseDTO;

import java.util.List;

public interface TicketService {
    List<AllTicketDeatailsResponseDTO> getAllTicketsByStatus(String ticketStatus);
}
