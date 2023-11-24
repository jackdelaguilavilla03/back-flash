package com.techcompany.backflash.company.service;

import com.techcompany.backflash.company.domain.model.Company;
import com.techcompany.backflash.company.domain.service.CompanyService;
import com.techcompany.backflash.company.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company createCompany(Company company) {
        Company newCompany = new Company(
                company.getEmail(),
                company.getCelular(),
                company.getPassword(),
                company.getFullname(),
                company.getBirthdate(),
                company.getAge(),
                company.getIdNumber(),
                company.getCountry(),
                company.getCountry(),
                company.getPhoto(),
                company.getTime(),
                company.getLicense(),
                company.getSoat(),
                company.getProperty_document(),
                company.getCertificate(),
                company.getPhotovehicle(),
                company.getPhotovehicle2(),
                company.getUser_name(),
                company.getUser_description()
        );
        Company savedCompany = companyRepository.save(newCompany);
        return savedCompany;
    }

    @Override
    public Optional<Company> getCompanyById(String id) {
        if (id.isEmpty()){
            throw new IllegalArgumentException("Not exist");
        }
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        if (companyRepository.findAll().isEmpty()){
            throw  new IllegalArgumentException("No Companies");
        }
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(String id,Company company) {
       if (companyRepository.findById(id).isEmpty()){
           throw new IllegalArgumentException("Company not found");
       }
       Company updateedCompany = new Company(
               company.getEmail(),
               company.getCelular(),
               company.getPassword(),
               company.getFullname(),
               company.getBirthdate(),
               company.getAge(),
               company.getIdNumber(),
               company.getCountry(),
               company.getCountry(),
               company.getPhoto(),
               company.getTime(),
               company.getLicense(),
               company.getSoat(),
               company.getProperty_document(),
               company.getCertificate(),
               company.getPhotovehicle(),
               company.getPhotovehicle2(),
               company.getUser_name(),
               company.getUser_description()
       );

       Company savedCompany = companyRepository.save(updateedCompany);
       return savedCompany;
    }

    @Override
    public void deleteCompany(String id) {
        if (companyRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("Client not found");
        }
        companyRepository.deleteById(id);
    }
}
