package com.ivanskiy.demo.domain;

import javax.persistence.*;

@Entity
@Table(name="airplane")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @Column(name="name")
    private String name;

    @Column(name="factory_serial_number")
    private int factorySerialNumber;

    @Column(name="air_company_id")
    private int airCompanyId;

    @Column(name="number_of_flights")
    private int numberOfFlights;

    @Column(name="flight_distance")
    private int flightDistance;

    @Column(name="fuel_capacity")
    private int fuelCapacity;

    @Column(name="type")
    private String type;

    @Column(name="created_at")
    private String createdAt;

    public Airplane() {
    }

    public Airplane(String name, int factorySerialNumber, int airCompanyId, int numberOfFlights,
                    int flightDistance, int fuelCapacity, String type, String createdAt) {
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.airCompanyId = airCompanyId;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public void setFactorySerialNumber(int factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }

    public int getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(int airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public int getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(int flightDistance) {
        this.flightDistance = flightDistance;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
