package com.iitcw.TicketingSystem.config;

import com.iitcw.TicketingSystem.dto.Systemconfigdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class AppInitializer {
    @Bean
    public Systemconfigdto AppInitializer() {
        Systemconfigdto  systemconfigdto = new Systemconfigdto();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter total number of tickets: ");
        int totalTickets = input.nextInt();
        systemconfigdto.setTotalNumberofTickets(totalTickets);

        System.out.println("Enter vendor ticket relese rate(milliseconds): ");
        int ticketRelease = input.nextInt();
        systemconfigdto.setTicketReleaseRate(ticketRelease);

        System.out.println("Enter customer retrieval rate(milliseconds): ");
        int customerRetrieveRate = input.nextInt();
        systemconfigdto.setCustomerRetrieverRate(customerRetrieveRate);

        System.out.println("Enter MaxCapacity :");
        int maxCapacity = input.nextInt();
        systemconfigdto.setMaxTicketCapacity(maxCapacity);


        return systemconfigdto;
    }
}
