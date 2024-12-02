package com.iitcw.TicketingSystem.thread;

import com.iitcw.TicketingSystem.dto.Systemconfigdto;
import com.iitcw.TicketingSystem.entity.Ticket;
import com.iitcw.TicketingSystem.repo.TicketRepo;
import com.iitcw.TicketingSystem.entity.Vendor;
import com.iitcw.TicketingSystem.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Vendorthread implements Runnable {


    private TicketRepo ticketRepo;


    private TicketPool ticketPool;


    private Systemconfigdto systemConfig;


    private VendorRepo vendorRepo;
    private int vendorId;

    public Vendorthread(TicketRepo ticketRepo, TicketPool ticketPool, Systemconfigdto systemConfig, VendorRepo vendorRepo) {
        this.ticketRepo = ticketRepo;
        this.ticketPool = ticketPool;
        this.systemConfig = systemConfig;
        this.vendorRepo = vendorRepo;

    }

    public Vendorthread(int vendorId) {
        this.vendorId = vendorId;
    }
    //
//
//    public Vendorthread(int vendorId) {
//        this.vendorId = vendorId;
//    }

    @Override
    public void run() {

        Vendor vendor = vendorRepo.findById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found"));


        int ticketCount = 0;
        while (ticketCount < systemConfig.getMaxTicketCapacity()) {
            Ticket ticket = new Ticket();
            ticket.setTicketId(ticketCount + 1);
            ticket.setTicketName("Ticket " + (ticketCount + 1));
            ticket.setTicketPrice(340.00);
            ticket.setTicketStatus("AVAILABLE");
            ticket.setVendor(vendor);


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
