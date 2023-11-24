package com.techcompany.backflash.client.domain.services;

import java.util.Optional;
import java.util.List;

import com.techcompany.backflash.client.domain.model.Client;

public interface ClientService {
  Client createClient(Client client);
  Optional<Client> getClientById(String id);
  List<Client> getAllClients();
  Client updateClient(String id,Client client);
  void deleteClient(String id);
} 
