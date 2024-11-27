package com.iitcw.TicketingSystem.dto.response;

import java.util.Date;

public class TicketPurchaseResponseDTO {
    private int purchaseTicketID;
    private Date purchaseDate;
    private int customerID;
    private int TicketID;

    public TicketPurchaseResponseDTO() {
    }

    public TicketPurchaseResponseDTO(int purchaseTicketID, Date purchaseDate, int customerID, int ticketID) {
        this.purchaseTicketID = purchaseTicketID;
        this.purchaseDate = purchaseDate;
        this.customerID = customerID;
        TicketID = ticketID;
    }

    public int getPurchaseTicketID() {
        return purchaseTicketID;
    }

    public void setPurchaseTicketID(int purchaseTicketID) {
        this.purchaseTicketID = purchaseTicketID;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getTicketID() {
        return TicketID;
    }

    public void setTicketID(int ticketID) {
        TicketID = ticketID;
    }
}
