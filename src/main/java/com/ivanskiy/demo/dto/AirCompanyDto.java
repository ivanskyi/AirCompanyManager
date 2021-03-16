package com.ivanskiy.demo.dto;

public class AirCompanyDto {

    private Integer ID;
    private String name;
    private String companyType;
    private String foundedAt;

    public AirCompanyDto(String name, String companyType, String foundedAt) {
        this.name = name;
        this.companyType = companyType;
        this.foundedAt = foundedAt;
    }

    public AirCompanyDto() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(String foundedAt) {
        this.foundedAt = foundedAt;
    }
}
