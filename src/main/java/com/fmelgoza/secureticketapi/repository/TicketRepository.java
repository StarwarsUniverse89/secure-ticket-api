package com.fmelgoza.secureticketapi.repository;

import com.fmelgoza.secureticketapi.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}