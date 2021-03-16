package com.ivanskiy.demo.domain;

import javax.persistence.*;

@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name="flight_status")
    private String flightStatus;

    @Column(name="air_company_id")
    private int AirCompanyId;

    @Column(name="airplane_id")
    private int airplaneId;

    @Column(name="departure_country")
    private String departureCountry;

    @Column(name="destination_country")
    private String destinationCountry;

    @Column(name="distance")
    private int distance;

    @Column(name="estimated_flight_time")
    private int estimatedFlightTime;

    @Column(name="ended_at")
    private String endedAt;

    @Column(name="delay_started_at")
    private String delayStartedAt;

    @Column(name="created_at")
    private String createdAt;

    public Flight() {
    }

    public Flight(int ID, String flightStatus, int airCompanyId, int airplaneId, String departureCountry, String destinationCountry, int distance, int estimatedFlightTime, String endedAt, String delayStartedAt, String createdAt) {
        this.ID = ID;
        this.flightStatus = flightStatus;
        AirCompanyId = airCompanyId;
        this.airplaneId = airplaneId;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
        this.endedAt = endedAt;
        this.delayStartedAt = delayStartedAt;
        this.createdAt = createdAt;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public int getAirCompanyId() {
        return AirCompanyId;
    }

    public void setAirCompanyId(int airCompanyId) {
        AirCompanyId = airCompanyId;
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
