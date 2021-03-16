package com.ivanskiy.demo.service;

import com.ivanskiy.demo.domain.Airplane;
import com.ivanskiy.demo.dto.AirplaneDto;
import com.ivanskiy.demo.repository.AirplaneRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirCompanyService airCompanyService;
    private final TimeManager timeManager;

    public AirplaneService(AirplaneRepository airplaneRepository, AirCompanyService airCompanyService,
                           TimeManager timeManager) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyService = airCompanyService;
        this.timeManager = timeManager;
    }

    public void createAirplane(AirplaneDto airplaneDto) {
        Airplane airplane = new Airplane();
        airplane.setName(airplaneDto.getName());
        airplane.setFactorySerialNumber(airplaneDto.getFactorySerialNumber());
        airplane.setAirCompanyId(airplaneDto.getAirCompanyId());
        airplane.setNumberOfFlights(airplaneDto.getNumberOfFlights());
        airplane.setFlightDistance(airplaneDto.getFlightDistance());
        airplane.setFuelCapacity(airplaneDto.getFuelCapacity());
        airplane.setType(airplaneDto.getType());
        airplane.setCreatedAt(timeManager.getCurrentTimeinString());
        airplaneRepository.save(airplane);
    }

    public void updateAirplane(Airplane airplane) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(airplane);
        transaction.commit();
        session.close();
    }

    public void changeOwner(int airplaneId, int companyOwnerId) {
        Airplane airplane = airplaneRepository.getAirplaneByID(airplaneId);
        airplane.setAirCompanyId(companyOwnerId);
        updateAirplane(airplane);
    }
}
