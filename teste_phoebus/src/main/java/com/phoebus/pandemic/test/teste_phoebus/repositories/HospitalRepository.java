package com.phoebus.pandemic.test.teste_phoebus.repositories;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

}