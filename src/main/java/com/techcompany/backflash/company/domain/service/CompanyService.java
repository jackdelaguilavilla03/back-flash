package com.techcompany.backflash.company.domain.service;

import com.techcompany.backflash.company.domain.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company createCompany(Company company);
    Optional<Company> getCompanyById(String id);
    List<Company> getAllCompanies();
    Company updateCompany( String id,Company company);
    void deleteCompany(String id);
}
