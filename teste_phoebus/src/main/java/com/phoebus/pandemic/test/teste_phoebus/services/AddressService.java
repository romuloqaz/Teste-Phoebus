package com.phoebus.pandemic.test.teste_phoebus.services;

import com.phoebus.pandemic.test.teste_phoebus.domain.Address;
import com.phoebus.pandemic.test.teste_phoebus.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repo;

    public Address find(Integer id) {
        Optional<Address> obj = repo.findById(id);
        return obj.orElse(null);
    }

}