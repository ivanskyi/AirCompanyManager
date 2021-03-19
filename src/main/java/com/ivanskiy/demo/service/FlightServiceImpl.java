package com.ivanskiy.demo.service;

import com.ivanskiy.demo.domain.Flight;
import com.ivanskiy.demo.dto.FlightDto;
import com.ivanskiy.demo.entity.FlightStatusCode;
import com.ivanskiy.demo.repository.FlightRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final AirCompanyServiceImpl airCompanyServiceImpl;
    private final TimeManagerImpl timeManagerImpl;

    public FlightServiceImpl(FlightRepository flightRepository, AirCompanyServiceImpl airCompanyServiceImpl,
                             TimeManagerImpl timeManagerImpl) {
        this.flightRepository = flightRepository;
        this.airCompanyServiceImpl = airCompanyServiceImpl;
        this.timeManagerImpl = timeManagerImpl;
    }

    @Override
    public void createFlight(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlightStatus("PENDING");
        flight.setAirCompanyId(flightDto.getAirCompanyId());
        flight.setAirplaneId(flightDto.getAirplaneId());
        flight.setDepartureCountry(flightDto.getDepartureCountry());
        flight.setDestinationCountry(flightDto.getDestinationCountry());
        flight.setDistance(flightDto.getDistance());
        flight.setEstimatedFlightTime(flightDto.getEstimatedFlightTime());
        flight.setEndedAt(flightDto.getEndedAt());
        flight.setDelayStartedAt(flightDto.getDelayStartedAt());
        flight.setCreatedAt(flightDto.getCreatedAt());
        flightRepository.save(flight);
    }

    @Override
    public String getStatus(String status) {
        FlightStatusCode statusCode = Arrays.stream(FlightStatusCode.values())
                .filter(a -> a.toString().equals(status.toUpperCase()))
                .findFirst()
                .orElse(FlightStatusCode.PENDING);
        return statusCode.toString();
    }

    @Override
    public List<Flight> getAllFlightByStatusCodeAndCompany(String status, String companyName) {
        int companyId = airCompanyServiceImpl.getAirCompanyByName(companyName).getID();
        List<Flight> result = new ArrayList<>();
        List<Flight> flights = flightRepository.findFlightsByFlightStatus(getStatus(status));
        for (Flight flight : flights) {
            if(flight.getAirCompanyId()==companyId) {
                result.add(flight);
            }
        }
        return result;
    }

    @Override
    public List<Flight> getAllFlightsThatFlyingLastsOver24Hours() {
        int countMinuteInOneDay = 1440;
        List<Flight> result = new ArrayList<>();
        List<Flight> flights = flightRepository.findFlightsByFlightStatus("ACTIVE");
        for (Flight flight : flights) {
            Date date = timeManagerImpl.getDateFromString(flight.getCreatedAt());
            long currentTime = new Date().getTime();
            int countMinuteAfterStart = timeManagerImpl.getMinuteFromMillisecond(currentTime - date.getTime());
            if(countMinuteAfterStart - countMinuteInOneDay > 0) {
                result.add(flight);
            }
        }
        return result;
    }

    @Override
    public List<Flight> getWhoLate() {
        List<Flight> flights = flightRepository.findFlightsByFlightStatus("COMPLETED");
        List<Flight> result = new ArrayList<>();
        for(Flight flight : flights) {
            Date startTime = timeManagerImpl.getDateFromString(flight.getCreatedAt());
            Date endTime = timeManagerImpl.getDateFromString(flight.getEndedAt());
            int timeSpendToFlight = timeManagerImpl.getTimeBeetwenStartAndEndFlight(startTime, endTime);
            if(flight.getEstimatedFlightTime() < timeSpendToFlight){
                result.add(flight);
            }
        }
        return result;
    }

    @Override
    public void changeStatusCodeAndSetSomeTimeInfo(int flightId, String newStatusCode, String date) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Flight flight = session.get(Flight.class, flightId);
        transaction.commit();
        session.close();

        switch (getStatus(newStatusCode)) {
            case("DELAYED"):
                flight.setDelayStartedAt(date);
                flight.setFlightStatus("DELAYED");
                break;
            case("ACTIVE"):
                flight.setCreatedAt(date);
                flight.setFlightStatus("ACTIVE");
                break;
            case("COMPLETED"):
                flight.setEndedAt(date);
                flight.setFlightStatus("COMPLETED");
                break;
        }

        updateFlight(flight);
    }

    @Override
    public void updateFlight(Flight flight) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(flight);
        transaction.commit();
        session.close();
    }
}
