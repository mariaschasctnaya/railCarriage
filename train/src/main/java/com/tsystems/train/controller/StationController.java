package com.tsystems.train.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.tsystems.train.facade.StationFacade;
import com.tsystems.train.facade.data.ResponseData;
import com.tsystems.train.facade.data.StationData;
import com.tsystems.train.facade.json.View;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/station")
public class StationController extends BaseController {
    @Autowired
    private StationFacade stationFacade;

    @PostMapping
    public ResponseData createStation(@RequestBody @Valid @JsonView(View.UI.class) StationData stationData) {
        log.debug("StationController: {} create request accepted", stationData.getName());
        stationFacade.createStation(stationData);
        return new ResponseData();
    }

    @GetMapping
    @JsonView(View.Server.class)
    public List<StationData> getStations(@RequestParam(value = "q", required = false) String query) {
        if (query == null) {
            log.debug("StationController: get all request accepted");
        } else {
            log.debug("StationController: get {} request accepted", query);
        }
        return stationFacade.getStations(query, true);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseData archiveStation(@PathVariable("id") String id) {
        stationFacade.archiveStation(id);
        return new ResponseData();
    }

    @GetMapping(path = "/all")
    public List<StationData> getAllStations() {
        return stationFacade.getStations(null, false);
    }

}
