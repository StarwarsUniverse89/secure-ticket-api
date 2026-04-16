package com.fmelgoza.secureticketapi.controller;

import com.fmelgoza.secureticketapi.model.Ticket;
import com.fmelgoza.secureticketapi.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping
    public Ticket createTicket(@Valid @RequestBody Ticket newTicket) {
        return ticketService.createTicket(newTicket);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @Valid @RequestBody Ticket updatedTicket) {
        return ticketService.updateTicket(id, updatedTicket);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return "Ticket deleted";
    }
}