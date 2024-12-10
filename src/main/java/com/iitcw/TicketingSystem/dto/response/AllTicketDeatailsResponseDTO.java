package com.iitcw.TicketingSystem.dto.response;

public class AllTicketDeatailsResponseDTO {
    private int ticketId;
    private String ticketName;
    private String ticketStatus;
    private double ticketPrice;

    public AllTicketDeatailsResponseDTO() {
    }

    public AllTicketDeatailsResponseDTO(int ticketId, String ticketName, String ticketStatus, double ticketPrice) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.ticketStatus = ticketStatus;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
