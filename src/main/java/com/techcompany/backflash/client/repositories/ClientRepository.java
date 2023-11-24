package com.techcompany.backflash.client.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcompany.backflash.client.domain.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}
