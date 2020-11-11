package com.phoebus.pandemic.test.teste_phoebus.repositories;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT h from Hospital h WHERE h.average > 90")
    List<Hospital> findHigherOccupation();

    @Transactional(readOnly = true)
    @Query("SELECT h from Hospital h WHERE h.average < 90")
    List<Hospital> findMinorOccupation();
}