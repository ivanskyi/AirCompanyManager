package com.ivanskiy.demo.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ivanskiy.demo.domain.Flight;
import com.ivanskiy.demo.dto.FlightDto;
import com.ivanskiy.demo.service.FlightService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("create")
    public void createComany(@RequestBody FlightDto flightDto) {
        flightService.createFlight(flightDto);
    }

    @GetMapping("getAllByStatusCodeAndCompanyName")
    @ResponseBody
    public List<Flight> getAllFlightsByStatusCodeAndCompanyName(String status, String companyName) {
         return flightService.getAllFlightByStatusCodeAndCompany(status, companyName);
    }

    @GetMapping("getAllThatFlyingOver24Hours")
    @ResponseBody
    public List<Flight> getAllThatFlyingOver24Hours() {
        return flightService.getAllFlightsThatFlyingLastsOver24Hours();
    }

    @GetMapping("getWhoLate")
    @ResponseBody
    public List<Flight> getCompleteFlightWhichLate() {
        return flightService.getWhoLate();
    }

    @PostMapping("changeStatusCode")
    public void changeStatusCodeAndSetSomeTimeInfo(@RequestBody ObjectNode jsonNodes) {
        flightService.changeStatusCodeAndSetSomeTimeInfo(jsonNodes.get("flightId").asInt(),
                jsonNodes.get("newStatusCode").asText(), jsonNodes.get("date").asText());
    }
}
