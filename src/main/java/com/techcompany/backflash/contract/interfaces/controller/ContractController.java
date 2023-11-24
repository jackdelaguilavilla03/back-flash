package com.techcompany.backflash.contract.interfaces.controller;

import com.techcompany.backflash.contract.domain.model.Contract;
import com.techcompany.backflash.contract.services.ContractServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contract", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ContractController {
    private final ContractServiceImpl contractService;

    public ContractController(ContractServiceImpl contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts(){
        return ResponseEntity.ok(contractService.getAllContracts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable String id){
        return ResponseEntity.ok(contractService.getContractById(id).get());
    }

    @PostMapping
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract){
        return ResponseEntity.ok(contractService.createContract(contract));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable String id, @RequestBody Contract contract){
        return ResponseEntity.ok(contractService.updateContract(id,contract));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable String id){
        contractService.deleteContract(id);
        return ResponseEntity.ok().build();
    }

}
