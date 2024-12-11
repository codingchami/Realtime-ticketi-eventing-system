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
        Systemconfigdto systemconfigdto = new Systemconfigdto();
        Scanner input = new Scanner(System.in);

        // Validate total number of tickets
        int totalTickets = getPositiveIntegerInput(input, "Enter total number of tickets: ");
        systemconfigdto.setTotalNumberofTickets(totalTickets);

        // Validate ticket release rate
        int ticketRelease = getPositiveIntegerInput(input, "Enter vendor ticket release rate (milliseconds): ");
        systemconfigdto.setTicketReleaseRate(ticketRelease);

        // Validate customer retrieval rate
        int customerRetrieveRate = getPositiveIntegerInput(input, "Enter customer retrieval rate (milliseconds): ");
        systemconfigdto.setCustomerRetrieverRate(customerRetrieveRate);

        // Validate max capacity
        int maxCapacity = getPositiveIntegerInput(input, "Enter MaxCapacity: ");

        // Ensure max capacity does not exceed total tickets
        while (maxCapacity > totalTickets) {
            System.out.println("Max capacity cannot exceed total number of tickets. Please enter a valid value.");
            maxCapacity = getPositiveIntegerInput(input, "Enter MaxCapacity: ");
        }
        systemconfigdto.setMaxTicketCapacity(maxCapacity);

        return systemconfigdto;
    }

    // Helper method to get and validate positive integer inputs
    private int getPositiveIntegerInput(Scanner input, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                value = input.nextInt();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Input must be a positive number. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next(); // Clear invalid input
            }
        }
        return value;
    }
}
