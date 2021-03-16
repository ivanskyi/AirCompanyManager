package com.ivanskiy.demo.controller;

import com.ivanskiy.demo.dto.AirplaneDto;
import com.ivanskiy.demo.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airplane")
public class AirplaneController {

    AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PostMapping("/add")
    public void addComany(@RequestBody AirplaneDto airplaneDto) {
        airplaneService.addAirplane(airplaneDto);
    }

    @PostMapping("/changeOwner/{airplaneName}/{companyName}")
    public void changeOwner(@PathVariable(name="airplaneName")
                                        String airplaneName, @PathVariable(name="companyName") String companyName) {
        airplaneService.changeOwner( airplaneName, companyName);
    }
}
