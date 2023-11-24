package com.techcompany.backflash.contract.domain.service;

import com.techcompany.backflash.contract.domain.model.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    Contract createContract(Contract contract);
    Optional<Contract> getContractById(String id);
    List<Contract> getAllContracts();
    Contract updateContract(String id, Contract contract);
    void deleteContract(String id);
}
