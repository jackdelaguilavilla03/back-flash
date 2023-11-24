package com.techcompany.backflash.contract.repositories;

import com.techcompany.backflash.contract.domain.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,String> {
}
