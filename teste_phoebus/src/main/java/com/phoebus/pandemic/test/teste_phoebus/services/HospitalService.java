package com.phoebus.pandemic.test.teste_phoebus.services;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.repositories.AddressRepository;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;
import com.phoebus.pandemic.test.teste_phoebus.repositories.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private OccupationRepository occupationRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Hospital find(Integer id) {
        Optional<Hospital> obj = hospitalRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Hospital.class.getName()));
    }
    public Hospital insert (Hospital obj){
        obj.setId(null);
        return hospitalRepository.save(obj);
    }

}