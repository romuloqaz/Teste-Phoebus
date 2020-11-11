package com.phoebus.pandemic.test.teste_phoebus.services;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.domain.HospitalDTO;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital find(Integer id) {
        Optional<Hospital> obj = hospitalRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Hospital.class.getName()));
    }

    @Transactional
    public Hospital insert (Hospital obj){
        obj.setId(null);
        return hospitalRepository.save(obj);
    }

    public Hospital update(Hospital obj) {
        Hospital hospital = find(obj.getId());
        hospital.setAverage(obj.getAverage());
        return hospital;
    }

    public List<Hospital> higherHospital(){
        List<Hospital> hospitals= hospitalRepository.findHigherOccupation();
        return hospitals;
    }


    public List<Hospital> minorHospital() {
        List<Hospital> hospitals= hospitalRepository.findMinorOccupation();
        return hospitals;
    }
}