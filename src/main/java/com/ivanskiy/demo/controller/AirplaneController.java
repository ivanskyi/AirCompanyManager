package com.ivanskiy.demo.controller;

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

    @PostMapping("changeOwner/{airplaneId}/{companyNewOwnerId}")
    public void changeOwner(@PathVariable(name = "airplaneId") Integer airplaneId,
                            @PathVariable(name = "companyNewOwnerId") Integer companyNewOwnerId) {
        airplaneService.changeOwner(airplaneId, companyNewOwnerId);
    }
}
