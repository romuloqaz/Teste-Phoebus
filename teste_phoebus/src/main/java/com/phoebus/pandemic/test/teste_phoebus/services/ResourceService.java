package com.phoebus.pandemic.test.teste_phoebus.services;

import com.phoebus.pandemic.test.teste_phoebus.domain.Resources;
import com.phoebus.pandemic.test.teste_phoebus.repositories.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ResourceService {

    @Autowired
    private ResourcesRepository repo;

    public Resources find(Integer id) {
        Optional<Resources> obj = repo.findById(id);
        return obj.orElse(null);
    }

}
