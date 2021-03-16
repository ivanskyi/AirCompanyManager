package com.ivanskiy.demo.dto;

public class AirplaneDto {

    private int ID;
    private String name;
    private int factorySerialNumber;
    private int airCompanyId;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
    private String type;
    private String createdAt;

    public AirplaneDto() {
    }

    public AirplaneDto(int ID, String name, int factorySerialNumber, int airCompanyId, int numberOfFlights,
                       int flightDistance, int fuelCapacity, String type, String createdAt) {
        this.ID = ID;
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.airCompanyId = airCompanyId;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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
