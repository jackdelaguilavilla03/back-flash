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
    public Contract updateContract(String id, Contract updatedContract) {
        Optional<Contract> optionalContract = contractRepository.findById(id);

        if (optionalContract.isEmpty()) {
            throw new IllegalArgumentException("Contract not found");
        }

        Contract existingContract = optionalContract.get();

        existingContract.setClientId(updatedContract.getClientId());
        existingContract.setCompanyId(updatedContract.getCompanyId());
        existingContract.setNombre(updatedContract.getNombre());
        existingContract.setFoto(updatedContract.getFoto());
        existingContract.setNombreServicio(updatedContract.getNombreServicio());
        existingContract.setFechaHoy(updatedContract.getFechaHoy());
        existingContract.setServicios(updatedContract.getServicios());
        existingContract.setDireccionEntrega(updatedContract.getDireccionEntrega());
        existingContract.setDireccionDestino(updatedContract.getDireccionDestino());
        existingContract.setFechaServicio(updatedContract.getFechaServicio());
        existingContract.setHoraServicio(updatedContract.getHoraServicio());
        existingContract.setNumeroTarjeta(updatedContract.getNumeroTarjeta());
        existingContract.setCvvTarjeta(updatedContract.getCvvTarjeta());
        existingContract.setVencimientoTarjeta(updatedContract.getVencimientoTarjeta());
        existingContract.setEstado(updatedContract.getEstado());
        existingContract.setRejectedPermanent(updatedContract.getRejectedPermanent());
        existingContract.setCostoServicio(updatedContract.getCostoServicio());
        existingContract.setAceptado(updatedContract.getAceptado());
        existingContract.setEstadoPermanente(updatedContract.getEstadoPermanente());

        return contractRepository.save(existingContract);
    }


    @Override
    public void deleteContract(String id) {
        if (contractRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("Contract not found");
        }
        contractRepository.deleteById(id);
    }
}
