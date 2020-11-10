package com.phoebus.pandemic.test.teste_phoebus.services;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository repo;

    public Hospital find(Integer id) {
        Optional<Hospital> obj = repo.findById(id);
        return obj.orElse(null);
    }

}