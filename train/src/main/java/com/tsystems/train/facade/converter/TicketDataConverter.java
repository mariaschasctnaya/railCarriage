package com.tsystems.train.facade.converter;

import com.tsystems.train.entity.Passenger;
import com.tsystems.train.entity.Ticket;
import com.tsystems.train.entity.Train;
import com.tsystems.train.facade.data.PassengerData;
import com.tsystems.train.facade.data.TicketData;
import com.tsystems.train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketDataConverter implements DtoConverter<TicketData, Ticket> {

    @Autowired
    private DtoConverter<PassengerData, Passenger> passengerConverter;
    @Autowired
    private TrainService trainService;

    @Override
    public Ticket convert(TicketData ticketData) {
        Train train = trainService.getTrainByNumber(ticketData.getTrainNumber());
        Passenger passenger = passengerConverter.convert(ticketData.getPassenger());
        return Ticket.builder()
                .train(train)
                .passenger(passenger)
                .build();
    }
}
