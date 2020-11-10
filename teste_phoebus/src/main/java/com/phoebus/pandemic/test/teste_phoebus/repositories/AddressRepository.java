package com.phoebus.pandemic.test.teste_phoebus.repositories;

import com.phoebus.pandemic.test.teste_phoebus.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}