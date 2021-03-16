package com.ivanskiy.demo.repository;

import com.ivanskiy.demo.domain.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
    Airplane getAirplaneByID(int id);
}

