package com.ivanskiy.demo.service;

import com.ivanskiy.demo.domain.Flight;
import com.ivanskiy.demo.dto.FlightDto;
import java.util.List;

public interface FlightService {

    void createFlight(FlightDto flightDto);

    String getStatus(String status);

    List<Flight> getAllFlightByStatusCodeAndCompany(String status, String companyName);

    List<Flight> getAllFlightsThatFlyingLastsOver24Hours();

    List<Flight> getWhoLate();

    void changeStatusCodeAndSetSomeTimeInfo(int flightId, String newStatusCode, String date);

    void updateFlight(Flight flight);
}
