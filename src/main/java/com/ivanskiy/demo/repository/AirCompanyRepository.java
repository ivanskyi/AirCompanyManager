package com.ivanskiy.demo.repository;

import com.ivanskiy.demo.domain.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Integer> {
    AirCompany getAirCompanyByName(String name);
}
