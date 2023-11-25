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
        return companyRepository.save(newCompany);
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
    public Company updateCompany(String id, Company updatedCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(id);

        if (optionalCompany.isEmpty()) {
            throw new IllegalArgumentException("Company not found");
        }

        Company existingCompany = optionalCompany.get();

        existingCompany.setEmail(updatedCompany.getEmail());
        existingCompany.setCelular(updatedCompany.getCelular());
        existingCompany.setPassword(updatedCompany.getPassword());
        existingCompany.setFullname(updatedCompany.getFullname());
        existingCompany.setBirthdate(updatedCompany.getBirthdate());
        existingCompany.setAge(updatedCompany.getAge());
        existingCompany.setIdNumber(updatedCompany.getIdNumber());
        existingCompany.setCountry(updatedCompany.getCountry());
        existingCompany.setPhoto(updatedCompany.getPhoto());
        existingCompany.setTime(updatedCompany.getTime());
        existingCompany.setLicense(updatedCompany.getLicense());
        existingCompany.setSoat(updatedCompany.getSoat());
        existingCompany.setProperty_document(updatedCompany.getProperty_document());
        existingCompany.setCertificate(updatedCompany.getCertificate());
        existingCompany.setPhotovehicle(updatedCompany.getPhotovehicle());
        existingCompany.setPhotovehicle2(updatedCompany.getPhotovehicle2());
        existingCompany.setUser_name(updatedCompany.getUser_name());
        existingCompany.setUser_description(updatedCompany.getUser_description());

        return companyRepository.save(existingCompany);
    }


    @Override
    public void deleteCompany(String id) {
        if (companyRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("Client not found");
        }
        companyRepository.deleteById(id);
    }
}
