package com.iitcw.TicketingSystem.Advisor;

public class TicketPurchaseNotFoundException extends RuntimeException{
    public TicketPurchaseNotFoundException(String message) {
        super(message);
    }
}
