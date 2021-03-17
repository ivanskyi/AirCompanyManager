package com.ivanskiy.demo.controller;

import com.ivanskiy.demo.domain.AirCompany;
import com.ivanskiy.demo.dto.AirCompanyDto;
import com.ivanskiy.demo.service.AirCompanyService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("company")

public class AirCompanyController {

    private final AirCompanyService airCompanyService;

    public AirCompanyController(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    @PostMapping("create")
    public void createCompany(@RequestBody AirCompanyDto airCompanyDto) {
        airCompanyService.createCompany(airCompanyDto);
    }

    @GetMapping("getById/{id}")
    public AirCompany getCompanyById(@PathVariable int id) {
        return airCompanyService.getCompanyById(id);
    }

    @GetMapping("getAll")
    @ResponseBody
    public List<AirCompany> getAllCompanies() {
        return airCompanyService.getAll();
    }

    @PostMapping("update")
    public void getCompanyById(@RequestBody AirCompanyDto airCompanyDto) {
        airCompanyService.updateAirCompany(airCompanyDto);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteCompanyById(@PathVariable("id") Integer id) {
        airCompanyService.deleteById(id);
    }
}
