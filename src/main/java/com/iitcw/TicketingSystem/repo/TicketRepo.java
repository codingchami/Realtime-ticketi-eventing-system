package com.iitcw.TicketingSystem.repo;

import com.iitcw.TicketingSystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TicketRepo extends JpaRepository<Ticket,Integer> {
}
