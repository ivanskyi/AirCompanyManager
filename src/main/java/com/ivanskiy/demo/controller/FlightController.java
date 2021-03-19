package com.ivanskiy.demo.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ivanskiy.demo.domain.Flight;
import com.ivanskiy.demo.dto.FlightDto;
import com.ivanskiy.demo.service.FlightServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {

    private final FlightServiceImpl flightServiceImpl;

    public FlightController(FlightServiceImpl flightServiceImpl) {
        this.flightServiceImpl = flightServiceImpl;
    }

    @PostMapping("create")
    public void createComany(@RequestBody FlightDto flightDto) {
        flightServiceImpl.createFlight(flightDto);
    }

    @GetMapping("getAllByStatusCodeAndCompanyName")
    @ResponseBody
    public List<Flight> getAllFlightsByStatusCodeAndCompanyName(String status, String companyName) {
         return flightServiceImpl.getAllFlightByStatusCodeAndCompany(status, companyName);
    }

    @GetMapping("getAllThatFlyingOver24Hours")
    @ResponseBody
    public List<Flight> getAllThatFlyingOver24Hours() {
        return flightServiceImpl.getAllFlightsThatFlyingLastsOver24Hours();
    }

    @GetMapping("getWhoLate")
    @ResponseBody
    public List<Flight> getCompleteFlightWhichLate() {
        return flightServiceImpl.getWhoLate();
    }

    @PostMapping("changeStatusCode")
    public void changeStatusCodeAndSetSomeTimeInfo(@RequestBody ObjectNode jsonNodes) {
        flightServiceImpl.changeStatusCodeAndSetSomeTimeInfo(jsonNodes.get("flightId").asInt(),
                jsonNodes.get("newStatusCode").asText(), jsonNodes.get("date").asText());
    }
}
