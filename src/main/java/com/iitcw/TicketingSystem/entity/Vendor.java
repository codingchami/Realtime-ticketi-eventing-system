package com.iitcw.TicketingSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "Vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id",length = 10)
    private int customerID;

    @Column(name = "customer_name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "customer_email",length = 50,nullable = false)
    private String email;

}
