package com.ivanskiy.demo.controller;

import com.ivanskiy.demo.domain.Flight;
import com.ivanskiy.demo.dto.FlightDto;
import com.ivanskiy.demo.service.FlightService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {
    FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/add")
    public void addComany(@RequestBody FlightDto flightDto) {
        flightService.addFlight(flightDto);
    }

    @GetMapping("getAllByStatusCodeAndCompanyName")
    @ResponseBody
    public List<Flight> getAllFlightsByStatusCodeAndCompanyName(String status, String companyName) {
         return flightService.getAllFlightByStatusCodeAndCompany(status, companyName);
    }

    @GetMapping("getAllThatFlyingOverOneDay")
    @ResponseBody
    public List<Flight> getAllFlightByStatusCodeAndCompanyName() {
        return flightService.getAllFlightsThatFlyingLastsOver24Hours();
    }

    @GetMapping("getCompletedWhichArrivedLate")
    @ResponseBody
    public List<Flight> getCompletedWhichArrivedLate() {
        return flightService.getCompletedWhichArrivedLate();
    }

    @GetMapping("changeStatusCode")
    public void changeStatusCodeAndSetSomeTimeInfo(int flightId,String newStatusCode, String date) {
        flightService.changeStatusCodeAndSetSomeTimeInfo(flightId, newStatusCode, date);
    }
}
