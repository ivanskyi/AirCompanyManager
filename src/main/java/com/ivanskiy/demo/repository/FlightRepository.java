package com.ivanskiy.demo.repository;

import com.ivanskiy.demo.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    List<Flight> findFlightsByFlightStatus(String status);
    Flight findFlightByID(int id);
}
