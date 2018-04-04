package com.tsystems.train.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import com.tsystems.train.facade.StationFacade;
import com.tsystems.train.facade.data.ResponseData;
import com.tsystems.train.facade.data.StationData;
import com.tsystems.train.facade.json.View;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//Causes lombok to generate a logger field.
@Slf4j
//add the @Controller and @ResponseBody annotations
//do not need to add @ResponseBody to all the request mapping methods.
@RestController
//annotation is need to set the controller's methods the address at which they will be available on the client
@RequestMapping("/station")
public class StationController extends BaseController {

    @Autowired
    private StationFacade stationFacade;

    @PostMapping
    @Secured("ROLE_MANAGER")
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
    @Secured("ROLE_MANAGER")
    public ResponseData archiveStation(@PathVariable("id") String id) {
        stationFacade.archiveStation(id);
        return new ResponseData();
    }

    @GetMapping(path = "/all")
    @Secured("ROLE_MANAGER")
    public List<StationData> getAllStations() {
        return stationFacade.getStations(null, false);
    }


}
