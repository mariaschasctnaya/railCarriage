package com.tsystems.train.facade.converter;

import com.tsystems.train.entity.Route;
import com.tsystems.train.entity.Train;
import com.tsystems.train.facade.data.TrainData;
import com.tsystems.train.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTrainDataConverter implements DtoConverter<TrainData, Train> {

    @Autowired
    private RouteService routeService;

    @Override
    public Train convert(TrainData source) {
        Route route = routeService.getRouteById(source.getRouteId());
        return Train.builder()
                .number(source.getNumber())
                .places(source.getPlaces())
                .route(route)
                .build();
    }
}