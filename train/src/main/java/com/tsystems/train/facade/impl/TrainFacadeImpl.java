package com.tsystems.train.facade.impl;

import com.tsystems.train.entity.EntityStatus;
import com.tsystems.train.entity.Route;
import com.tsystems.train.entity.StationStatus;
import com.tsystems.train.entity.Train;
import com.tsystems.train.facade.TrainFacade;
import com.tsystems.train.facade.converter.DtoConverter;
import com.tsystems.train.facade.data.SearchTrainData;
import com.tsystems.train.facade.data.TrainData;
import com.tsystems.train.service.RouteService;
import com.tsystems.train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TrainFacadeImpl implements TrainFacade {


    @Autowired
    private TrainService trainService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private DtoConverter<TrainData, Train> createTrainDataConverter;
    @Autowired
    private DtoConverter<Train, TrainData> trainConverter;

    @Override
    public void createTrain(TrainData trainData) {
        Train train = createTrainDataConverter.convert(trainData);
        trainService.createTrain(train);
    }

    @Override
    public List<TrainData> searchTrains(SearchTrainData searchTrainData) {
        return trainService.searchTrain(searchTrainData.getDeparture(), searchTrainData.getArrived(),
                searchTrainData.getStartDate(), searchTrainData.getEndDate())
                .stream()
                .filter(this::filterByStatus)
                .filter(train -> byStatusStations(train, searchTrainData))
                .map(trainConverter::convert)
                .collect(Collectors.toList());
    }

    private boolean byStatusStations(Train train, SearchTrainData searchTrainData) {
        if (train.getStationStatuses() != null) {
            StationStatus.Status arrivedStatus = getStationStatus(train, searchTrainData.getArrived());
            StationStatus.Status departureStatus = getStationStatus(train, searchTrainData.getDeparture());
            return arrivedStatus != StationStatus.Status.CANCELED && departureStatus != StationStatus.Status.CANCELED;
        }
        return true;
    }

    private StationStatus.Status getStationStatus(Train train, String station) {
        return train.getStationStatuses().stream()
                .filter(status -> status.getStation().getName().equals(station))
                .findFirst()
                .map(StationStatus::getStatus)
                .orElse(StationStatus.Status.OK);
    }

    @Override
    public List<TrainData> getTrains(String station, boolean filter) {
        Stream<Train> trains = trainService.getTrains(station).stream();
        if (filter) {
            trains = trains.filter(this::filterByStatus);
        }
        return trains.map(trainConverter::convert).collect(Collectors.toList());
    }

    private boolean filterByStatus(Train train) {
        return train.getStatus() == EntityStatus.ACTIVE;
    }



    @Override
    public void archiveTrain(String id) {
        Train train = trainService.getTrainById(id);
        trainService.archive(train);
    }

    @Override
    public void archiveTrainByRoute(String routeId) {
        Route route = routeService.getRouteById(routeId);
        trainService.archiveTrainByRoute(route);
    }


}
