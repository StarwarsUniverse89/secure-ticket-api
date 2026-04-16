package com.fmelgoza.secureticketapi.service;

import com.fmelgoza.secureticketapi.model.Ticket;
import com.fmelgoza.secureticketapi.repository.TicketRepository;
import com.fmelgoza.secureticketapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + id));
    }

    public Ticket createTicket(Ticket newTicket) {
        return ticketRepository.save(newTicket);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        if (!ticketRepository.existsById(id)) {
            throw new ResourceNotFoundException("Ticket not found with id " + id);
        }
        updatedTicket.setId(id);
        return ticketRepository.save(updatedTicket);
    }

    public void deleteTicket(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new ResourceNotFoundException("Ticket not found with id " + id);
        }
        ticketRepository.deleteById(id);
    }
}