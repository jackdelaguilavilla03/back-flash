package com.techcompany.backflash.client.service;

import java.util.List;
import java.util.Optional;

import com.techcompany.backflash.client.domain.model.Client;
import com.techcompany.backflash.client.domain.services.ClientService;
import com.techcompany.backflash.client.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServicesImpl implements ClientService {
  private final ClientRepository clientRepository;

  public ClientServicesImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Client createClient(Client client) {
    Client newClient = new Client(
        client.getEmail(),
        client.getCelular(),
        client.getPassword(),
        client.getFullname(),
        client.getBirthdate(),
        client.getIdNumber(),
        client.getCountry(),
        client.getPhoto(),
        client.getUser_name(),
        client.getUser_description());

    Client savedClient = clientRepository.save(newClient);
    return savedClient;
  }

  @Override
  public Optional<Client> getClientById(String id) {
    if (id == null) {
      throw new IllegalArgumentException("Id cannot be null");
    }
    return clientRepository.findById(id);
  }

  @Override
  public List<Client> getAllClients() {
    if (clientRepository.findAll().isEmpty()) {
      throw new IllegalArgumentException("No clients found");
    }
    return clientRepository.findAll();
  }

  @Override
  public Client updateClient(String id,Client client) {
    if (clientRepository.findById(id).isEmpty()) {
      throw new IllegalArgumentException("Client not found");
    }
    Client updatedClient = new Client(
        client.getEmail(),
        client.getCelular(),
        client.getPassword(),
        client.getFullname(),
        client.getBirthdate(),
        client.getIdNumber(),
        client.getCountry(),
        client.getPhoto(),
        client.getUser_name(),
        client.getUser_description());

    Client savedClient = clientRepository.save(updatedClient);
    return savedClient;
  }

  @Override
  public void deleteClient(String id) {
    if (clientRepository.findById(id).isEmpty()) {
      throw new IllegalArgumentException("Client not found");
    }
    clientRepository.deleteById(id);
  }

}
