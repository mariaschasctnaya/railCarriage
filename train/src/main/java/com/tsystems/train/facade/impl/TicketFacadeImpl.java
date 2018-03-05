package com.tsystems.train.facade.impl;

import com.tsystems.train.entity.Ticket;
import com.tsystems.train.entity.Train;
import com.tsystems.train.facade.TicketFacade;
import com.tsystems.train.facade.converter.DtoConverter;
import com.tsystems.train.facade.data.TicketData;
import com.tsystems.train.service.TicketService;
import com.tsystems.train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketFacadeImpl implements TicketFacade {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private DtoConverter<TicketData, Ticket> ticketDataConverter;

    @Override
    public String createTicket(TicketData ticket) {
        String trainNumber = ticket.getTrainNumber();
        Train train = trainService.getTrainByNumber(trainNumber);
        trainService.checkAvailableTrainByStation(train, ticket.getStation());
        ticketService.checkAvailableTickets(train);
        Ticket savedTicket = ticketService.createTicket(ticketDataConverter.convert(ticket));
        return savedTicket.getNumber();
    }

    @Override
    public int findCountTicketByTrain(String trainNumber) {
        Train train = trainService.getTrainByNumber(trainNumber);
        List <Ticket> tickets = ticketService.getTicketForTrain(train);
        return tickets.size();
    }

}
