package com.ivanskiy.demo.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ivanskiy.demo.dto.AirplaneDto;
import com.ivanskiy.demo.service.AirplaneServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airplane")
public class AirplaneController {

    private final AirplaneServiceImpl airplaneServiceImpl;

    public AirplaneController(AirplaneServiceImpl airplaneServiceImpl) {
        this.airplaneServiceImpl = airplaneServiceImpl;
    }

    @PostMapping("create")
    public void createComany(@RequestBody AirplaneDto airplaneDto) {
        airplaneServiceImpl.createAirplane(airplaneDto);
    }

    @PostMapping("changeOwner")
    public void changeOwner(@RequestBody ObjectNode objectNode) {
        airplaneServiceImpl.changeOwner(objectNode.get("airplaneId").asInt(),
                objectNode.get("companyNewOwnerId").asInt());
    }
}
