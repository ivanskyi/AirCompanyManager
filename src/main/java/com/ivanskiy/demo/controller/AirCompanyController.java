package com.ivanskiy.demo.controller;

import com.ivanskiy.demo.domain.AirCompany;
import com.ivanskiy.demo.dto.AirCompanyDto;
import com.ivanskiy.demo.service.AirCompanyServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("company")

public class AirCompanyController {

    private final AirCompanyServiceImpl airCompanyServiceImpl;

    public AirCompanyController(AirCompanyServiceImpl airCompanyServiceImpl) {
        this.airCompanyServiceImpl = airCompanyServiceImpl;
    }

    @PostMapping("create")
    public void createCompany(@RequestBody AirCompanyDto airCompanyDto) {
        airCompanyServiceImpl.createCompany(airCompanyDto);
    }

    @GetMapping("getById/{id}")
    public AirCompany getCompanyById(@PathVariable int id) {
        return airCompanyServiceImpl.getCompanyById(id);
    }

    @GetMapping("getAll")
    @ResponseBody
    public List<AirCompany> getAllCompanies() {
        return airCompanyServiceImpl.getAll();
    }

    @PostMapping("update")
    public void getCompanyById(@RequestBody AirCompanyDto airCompanyDto) {
        airCompanyServiceImpl.updateAirCompany(airCompanyDto);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteCompanyById(@PathVariable("id") Integer id) {
        airCompanyServiceImpl.deleteById(id);
    }
}
