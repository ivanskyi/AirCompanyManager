package com.ivanskiy.demo.service;

import com.ivanskiy.demo.domain.Airplane;
import com.ivanskiy.demo.dto.AirplaneDto;

public interface AirplaneService {

    void createAirplane(AirplaneDto airplaneDto);

    void updateAirplane(Airplane airplane);

    void changeOwner(int airplaneId, int companyOwnerId) ;
}
