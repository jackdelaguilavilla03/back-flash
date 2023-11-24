package com.techcompany.backflash.company.interfaces.controller;

import com.techcompany.backflash.company.domain.model.Company;
import com.techcompany.backflash.company.service.CompanyServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CompanyController {
    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable String id){
        return ResponseEntity.ok(companyService.getCompanyById(id).get());
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.createCompany(company));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable String id, @RequestBody Company company){
        return ResponseEntity.ok(companyService.updateCompany(id, company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable String id){
        companyService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }
}
