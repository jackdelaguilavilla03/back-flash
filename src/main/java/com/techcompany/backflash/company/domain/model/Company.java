package com.techcompany.backflash.company.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id = UUID.randomUUID().toString();
    String email;
    String celular;
    String password;
    String fullname;
    String birthdate;
    String age;
    String idNumber;
    String country;
    String photo;
    String job;
    String time;
    String license;
    String soat;
    String property_document;
    String certificate;
    String photovehicle;
    String photovehicle2;
    String user_name;
    String user_description;

    public Company(String email, String celular, String password, String fullname, String birthdate, String age, String idNumber, String country, String photo, String job, String time, String license, String soat, String property_document, String certificate, String photovehicle, String photovehicle2, String user_name, String user_description) {
        this.email = email;
        this.celular = celular;
        this.password = password;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.age = age;
        this.idNumber = idNumber;
        this.country = country;
        this.photo = photo;
        this.job = job;
        this.time = time;
        this.license = license;
        this.soat = soat;
        this.property_document = property_document;
        this.certificate = certificate;
        this.photovehicle = photovehicle;
        this.photovehicle2 = photovehicle2;
        this.user_name = user_name;
        this.user_description = user_description;
    }
}
