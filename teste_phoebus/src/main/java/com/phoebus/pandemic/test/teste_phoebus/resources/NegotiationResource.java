package com.phoebus.pandemic.test.teste_phoebus.resources;

import com.phoebus.pandemic.test.teste_phoebus.domain.Negotiation;
import com.phoebus.pandemic.test.teste_phoebus.services.NegotiationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/negociacoes")
public class NegotiationResource {

    @Autowired
    private NegotiationService service;
    @ApiOperation(value="Lista todas as negociacoes")
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Negotiation>>findAll() {
        List<Negotiation> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}