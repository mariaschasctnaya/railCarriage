package com.tsystems.train.controllers;

import com.tsystems.train.facade.TicketFacade;
import com.tsystems.train.facade.data.TicketData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController extends BaseController {

    @Autowired
    private TicketFacade ticketFacade;

    @PostMapping
    public String createTicket(@RequestBody @Valid TicketData ticket) {
        log.debug("TicketController: create ticket for passenger {} request accepted", ticket.getPassenger());
        return ticketFacade.createTicket(ticket);
    }

    @GetMapping
    public int getCountTicketsOfTrains(@RequestBody @RequestParam("number") String number) {
        return ticketFacade.findCountTicketByTrain(number);
    }

}
