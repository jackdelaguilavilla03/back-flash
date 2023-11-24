package com.techcompany.backflash.client.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.lang.String;
import java.util.UUID;

@Entity
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id = UUID.randomUUID().toString();
    private String email;
    private String celular;
    private String password;
    private String fullname;
    private String birthdate;
    private String idNumber;
    private String country;
    private String photo;
    private String user_name;
    private String user_description;
    public Client ( String email, String celular, String password, String fullname, String birthdate, String idNumber, String country, String photo, String user_name, String user_description) {
        this.email = email;
        this.celular = celular;
        this.password = password;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.idNumber = idNumber;
        this.country = country;
        this.photo = photo;
        this.user_name = user_name;
        this.user_description = user_description;
    }
}
