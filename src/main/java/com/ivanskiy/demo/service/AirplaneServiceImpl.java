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
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirCompanyServiceImpl airCompanyServiceImpl;
    private final TimeManagerImpl timeManagerImpl;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository, AirCompanyServiceImpl airCompanyServiceImpl,
                               TimeManagerImpl timeManagerImpl) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyServiceImpl = airCompanyServiceImpl;
        this.timeManagerImpl = timeManagerImpl;
    }

    @Override
    public void createAirplane(AirplaneDto airplaneDto) {
        Airplane airplane = new Airplane();
        airplane.setName(airplaneDto.getName());
        airplane.setFactorySerialNumber(airplaneDto.getFactorySerialNumber());
        airplane.setAirCompanyId(airplaneDto.getAirCompanyId());
        airplane.setNumberOfFlights(airplaneDto.getNumberOfFlights());
        airplane.setFlightDistance(airplaneDto.getFlightDistance());
        airplane.setFuelCapacity(airplaneDto.getFuelCapacity());
        airplane.setType(airplaneDto.getType());
        airplane.setCreatedAt(timeManagerImpl.getCurrentTimeinString());
        airplaneRepository.save(airplane);
    }

    @Override
    public void updateAirplane(Airplane airplane) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(airplane);
        transaction.commit();
        session.close();
    }

    @Override
    public void changeOwner(int airplaneId, int companyOwnerId) {
        Airplane airplane = airplaneRepository.getAirplaneByID(airplaneId);
        airplane.setAirCompanyId(companyOwnerId);
        updateAirplane(airplane);
    }
}
