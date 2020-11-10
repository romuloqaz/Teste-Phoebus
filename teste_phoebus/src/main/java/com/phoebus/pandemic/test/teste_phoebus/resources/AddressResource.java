package com.phoebus.pandemic.test.teste_phoebus.resources;

import com.phoebus.pandemic.test.teste_phoebus.domain.Address;
import com.phoebus.pandemic.test.teste_phoebus.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/enderecos")
public class AddressResource {

    @Autowired
    private AddressService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Address> find(@PathVariable Integer id) {
        Address obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}