package com.ivanskiy.demo.dto;

public class FlightDto {
    private Integer ID;
    private String flightStatus;
    private int airCompanyId;
    private int airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private String endedAt;
    private String delayStartedAt;
    private String createdAt;

    public FlightDto() {
    }

    public FlightDto(String flightStatus, int airCompanyId, int airplaneId, String departureCountry,
                     String destinationCountry, int distance, int estimatedFlightTime, String endedAt,
                     String delayStartedAt, String createdAt) {
        this.flightStatus = flightStatus;
        this.airCompanyId = airCompanyId;
        this.airplaneId = airplaneId;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
        this.endedAt = endedAt;
        this.delayStartedAt = delayStartedAt;
        this.createdAt = createdAt;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public int getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(int airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public void setEstimatedFlightTime(int estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }

    public String getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(String endedAt) {
        this.endedAt = endedAt;
    }

    public String getDelayStartedAt() {
        return delayStartedAt;
    }

    public void setDelayStartedAt(String delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
