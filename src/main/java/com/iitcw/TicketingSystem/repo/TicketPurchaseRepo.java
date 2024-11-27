package com.iitcw.TicketingSystem.repo;

import com.iitcw.TicketingSystem.entity.TicketPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TicketPurchaseRepo extends JpaRepository<TicketPurchase,Integer> {

}
