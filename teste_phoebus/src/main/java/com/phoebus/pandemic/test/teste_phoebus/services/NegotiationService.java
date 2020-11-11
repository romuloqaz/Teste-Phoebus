package com.phoebus.pandemic.test.teste_phoebus.services;

import com.phoebus.pandemic.test.teste_phoebus.domain.Negotiation;
import com.phoebus.pandemic.test.teste_phoebus.repositories.NegotiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NegotiationService {

    @Autowired
    private NegotiationRepository negotiationRepository;

    @Transactional
    public Negotiation insert (Negotiation obj){
        obj.setId(null);
        return negotiationRepository.save(obj);
    }

    public List<Negotiation> findAll() {
        return negotiationRepository.findAll();
    }

}
