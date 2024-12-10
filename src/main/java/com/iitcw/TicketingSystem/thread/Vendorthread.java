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
    private final TicketPool ticketPool;

    public Vendorthread(int vendorId, TicketRepo ticketRepo, VendorRepo vendorRepo, Systemconfigdto systemConfig,TicketPool ticketPool) {
        this.vendorId = vendorId;
        this.ticketRepo = ticketRepo;
        this.vendorRepo = vendorRepo;
        this.systemConfig = systemConfig;
        this.ticketPool = ticketPool;
    }



    @Override
    public void run() {
        if (vendorId == 0) {
            throw new RuntimeException("Vendor id not set");
        }

        int ticketCount = 0;

        while (true) {
            synchronized (ticketPool) {
                if (ticketRepo.count() >= systemConfig.getTotalNumberofTickets()) {
                    System.out.println("All tickets for the event have been released.");
                    break;
                }

                if (ticketCount >= systemConfig.getMaxTicketCapacity()) {
                    System.out.println("Vendor " + vendorId + " reached maximum ticket release capacity.");
                    break;
                }

                Ticket ticket = new Ticket();
                ticket.setTicketName("Ticket " + (ticketRepo.count() + 1));
                ticket.setTicketPrice(340.00);
                ticket.setTicketStatus("AVAILABLE");
                ticket.setVendorId(vendorId);

                ticketRepo.save(ticket);
                ticketPool.addTicket(ticket);

                System.out.println("Vendor " + vendorId + " released ticket: " + ticket.getTicketName());

                ticketCount++;

                try {
                    Thread.sleep(systemConfig.getTicketReleaseRate());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}