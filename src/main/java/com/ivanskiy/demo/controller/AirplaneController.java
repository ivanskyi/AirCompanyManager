package com.ivanskiy.demo.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ivanskiy.demo.dto.AirplaneDto;
import com.ivanskiy.demo.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airplane")
public class AirplaneController {

    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PostMapping("create")
    public void createComany(@RequestBody AirplaneDto airplaneDto) {
        airplaneService.createAirplane(airplaneDto);
    }

    @PostMapping("changeOwner")
    public void changeOwner(@RequestBody ObjectNode objectNode) {
        airplaneService.changeOwner(objectNode.get("airplaneId").asInt(),
                objectNode.get("companyNewOwnerId").asInt());
    }
}
