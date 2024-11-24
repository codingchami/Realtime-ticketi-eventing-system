package com.iitcw.TicketingSystem.dto;

public class Systemconfigdto {
    private int totalNumberofTickets;
    private int ticketReleaseRate;
    private int customerRetrieverRate;
    private int maxTicketCapacity;

    public Systemconfigdto() {
    }

    public Systemconfigdto(int totalNumberofTickets, int ticketReleaseRate, int customerRetrieverRate, int minTicketCapacity) {
        this.setTotalNumberofTickets(totalNumberofTickets);
        this.setTicketReleaseRate(ticketReleaseRate);
        this.setCustomerRetrieverRate(customerRetrieverRate);
        this.setMaxTicketCapacity(getMaxTicketCapacity());
    }

    public int getTotalNumberofTickets() {
        return totalNumberofTickets;
    }

    public void setTotalNumberofTickets(int totalNumberofTickets) {
        this.totalNumberofTickets = totalNumberofTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrieverRate() {
        return customerRetrieverRate;
    }

    public void setCustomerRetrieverRate(int customerRetrieverRate) {
        this.customerRetrieverRate = customerRetrieverRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }
}
