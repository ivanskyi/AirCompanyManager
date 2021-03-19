package com.ivanskiy.demo.service;

import com.ivanskiy.demo.domain.AirCompany;
import com.ivanskiy.demo.dto.AirCompanyDto;
import java.util.List;

public interface AirCompanyService {

    void createCompany(AirCompanyDto airCompanyDto);

    AirCompany getCompanyById(int id);

    void updateAirCompany(AirCompanyDto airCompanyDto);

    void deleteById(Integer id );

    AirCompany getAirCompanyByName(String companyName);

    List<AirCompany> getAll();
}
