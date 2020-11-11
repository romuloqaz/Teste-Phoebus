package com.phoebus.pandemic.test.teste_phoebus.repositories;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Transactional(readOnly = true)
    @Query(value = "SELECT h from Hospital h WHERE h.average < 90 order by h.dateUpdate asc")
    List<Hospital> findOccupationLonger(Pageable pageable);

    @Transactional(readOnly = true)
    @Query(value = "SELECT h from Hospital h WHERE h.average > 90 order by h.dateUpdate asc")
    List<Hospital> findOccupationHigher(Pageable pageable);

    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(*)\n" +
            "FROM HOSPITAL h, RESOURCES r, HOSPITAL_RESOURCES hr \n" +
            "WHERE hr.HOSPITAL_ID = h.ID AND hr.RESOURCES_ID = r.ID AND r.NAME LIKE %:nome%", nativeQuery = true)
    Float countResources(@Param("nome") String nome);

    @Transactional(readOnly = true)
    @Query("SELECT count(h) FROM Hospital h")
    Float CountHospital();

}