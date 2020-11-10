package com.phoebus.pandemic.test.teste_phoebus.services;

import com.phoebus.pandemic.test.teste_phoebus.domain.Occupation;
import com.phoebus.pandemic.test.teste_phoebus.repositories.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OccupationService {

    @Autowired
    private OccupationRepository repo;

    public Occupation find(Integer id) {
        Optional<Occupation> obj = repo.findById(id);
        return obj.orElse(null);
    }

}