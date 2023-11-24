package com.techcompany.backflash.client.interfaces.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techcompany.backflash.client.domain.model.Client;
import com.techcompany.backflash.client.service.ClientServicesImpl;

@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ClientController {
  private final ClientServicesImpl clientServicesImpl;

  public ClientController(ClientServicesImpl clientServicesImpl) {
    this.clientServicesImpl = clientServicesImpl;
  }


  @GetMapping
  public ResponseEntity<List<Client>> getAllClients() {
    return ResponseEntity.ok(clientServicesImpl.getAllClients());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> getClientById(@PathVariable String id) {
    return ResponseEntity.ok(clientServicesImpl.getClientById(id).get());
  }

  @PostMapping
  public ResponseEntity<Client> createClient(@RequestBody Client client) {
    return ResponseEntity.ok(clientServicesImpl.createClient(client));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Client> updateClient(@PathVariable String id,@RequestBody Client client) {
    return ResponseEntity.ok(clientServicesImpl.updateClient(id, client));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable String id) {
    clientServicesImpl.deleteClient(id);
    return ResponseEntity.ok().build();
  }
}
