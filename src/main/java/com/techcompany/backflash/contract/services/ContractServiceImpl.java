package com.techcompany.backflash.contract.services;

import com.techcompany.backflash.contract.domain.model.Contract;
import com.techcompany.backflash.contract.domain.service.ContractService;
import com.techcompany.backflash.contract.repositories.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract createContract(Contract contract) {
        Contract newContract = new Contract(
                contract.getClientId(),
                contract.getCompanyId(),
                contract.getNombre(),
                contract.getFoto(),
                contract.getNombreServicio(),
                contract.getFechaHoy(),
                contract.getServicios(),
                contract.getDireccionEntrega(),
                contract.getDireccionDestino(),
                contract.getFechaServicio(),
                contract.getHoraServicio(),
                contract.getNumeroTarjeta(),
                contract.getCvvTarjeta(),
                contract.getVencimientoTarjeta(),
                contract.getEstado(),
                contract.getRejectedPermanent(),
                contract.getCostoServicio(),
                contract.getAceptado(),
                contract.getEstadoPermanente()
                );
        return contractRepository.save(newContract);
    }

    @Override
    public Optional<Contract> getContractById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return contractRepository.findById(id);
    }

    @Override
    public List<Contract> getAllContracts() {
        if (contractRepository.findAll().isEmpty()) {
            throw new IllegalArgumentException("No contract found");
        }
        return contractRepository.findAll();
    }

    @Override
    public Contract updateContract(String id, Contract contract) {
        if (contractRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Contract not found");
        }
        Contract newContract = new Contract(
                contract.getClientId(),
                contract.getCompanyId(),
                contract.getNombre(),
                contract.getFoto(),
                contract.getNombreServicio(),
                contract.getFechaHoy(),
                contract.getServicios(),
                contract.getDireccionEntrega(),
                contract.getDireccionDestino(),
                contract.getFechaServicio(),
                contract.getHoraServicio(),
                contract.getNumeroTarjeta(),
                contract.getCvvTarjeta(),
                contract.getVencimientoTarjeta(),
                contract.getEstado(),
                contract.getRejectedPermanent(),
                contract.getCostoServicio(),
                contract.getAceptado(),
                contract.getEstadoPermanente()
        );
        return contractRepository.save(newContract);
    }

    @Override
    public void deleteContract(String id) {
        if (contractRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("Contract not found");
        }
        contractRepository.deleteById(id);
    }
}
