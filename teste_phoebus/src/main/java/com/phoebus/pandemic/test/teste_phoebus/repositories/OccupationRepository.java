package com.phoebus.pandemic.test.teste_phoebus.repositories;

import com.phoebus.pandemic.test.teste_phoebus.domain.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation,Integer> {

}