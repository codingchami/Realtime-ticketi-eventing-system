package com.iitcw.TicketingSystem.thread;

import com.iitcw.TicketingSystem.dto.Systemconfigdto;
import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.repo.TicketRepo;
import com.iitcw.TicketingSystem.repo.VendorRepo;

public class Vendorthread implements Runnable {

    private final TicketRepo ticketRepo;
    private final VendorRepo vendorRepo;
    private final Systemconfigdto systemConfig;
    private final int vendorId;

    public Vendorthread(int vendorId, TicketRepo ticketRepo, VendorRepo vendorRepo, Systemconfigdto systemConfig) {
        this.vendorId = vendorId;
        this.ticketRepo = ticketRepo;
        this.vendorRepo = vendorRepo;
        this.systemConfig = systemConfig;
    }

    @Override
    public void run() {
        if (vendorId == 0) {
            throw new RuntimeException("Vendor id not set");
        }
        int ticketCount = 0;
        while (ticketCount < systemConfig.getMaxTicketCapacity()) {
            Ticket ticket = new Ticket();
            ticket.setTicketId(ticketCount + 1);
            ticket.setTicketName("Ticket " + (ticketCount + 1));
            ticket.setTicketPrice(340.00);
            ticket.setTicketStatus("AVAILABLE");
            ticket.setVendorId(vendorId);

            ticketRepo.save(ticket);
            ticketCount++;

            try {
                Thread.sleep(systemConfig.getTicketReleaseRate());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
