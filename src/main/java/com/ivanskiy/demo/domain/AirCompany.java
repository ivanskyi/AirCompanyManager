package com.ivanskiy.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="air_company")
public class AirCompany implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer ID;

        @Column(name="name")
        private String name;

        @Column(name="company_type")
        private String companyType;

        @Column(name="founded_at")
        private String foundedAt;

        public AirCompany() {
        }

        public AirCompany(String name, String companyType, String foundedAt) {
                this.name = name;
                this.companyType = companyType;
                this.foundedAt = foundedAt;
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
