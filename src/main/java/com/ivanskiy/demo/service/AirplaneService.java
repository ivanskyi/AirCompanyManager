package com.ivanskiy.demo.service;

import com.ivanskiy.demo.domain.Airplane;
import com.ivanskiy.demo.dto.AirplaneDto;
import com.ivanskiy.demo.repository.AirplaneRepository;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService {

    AirplaneRepository airplaneRepository;
    AirCompanyService airCompanyService;

    public AirplaneService(AirplaneRepository airplaneRepository, AirCompanyService airCompanyService) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyService = airCompanyService;
    }

    public void addAirplane(AirplaneDto airplaneDto) {
        Airplane airplane = new Airplane();
        airplane.setName(airplaneDto.getName());
        airplaneRepository.save(airplane);
    }

    public void updateAirplane(Airplane airplane) {
        ///DOTO
        ////Here must realize update airplane
    }

    public void changeOwner(String airplaneName, String companyName) {
        Airplane airplane = getAirplaneByName(airplaneName);
        Integer companyId = airCompanyService.getAirCompanyByName(companyName).getID().intValue();

        if (airplane != null) {
            airplane.setAirCompanyId(companyId);
            updateAirplane(airplane);
        }
    }

    public Airplane getAirplaneByName(String airplaneName) {
        Airplane airplane = airplaneRepository.getAirplaneByName(airplaneName);
        if (airplane == null) {
            airplane = new Airplane();
        }
        return airplane;
    }
}
