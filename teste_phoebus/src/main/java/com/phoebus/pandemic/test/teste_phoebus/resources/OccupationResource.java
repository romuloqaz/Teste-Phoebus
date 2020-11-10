package com.phoebus.pandemic.test.teste_phoebus.resources;


import com.phoebus.pandemic.test.teste_phoebus.domain.Occupation;
import com.phoebus.pandemic.test.teste_phoebus.services.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ocupacao")
public class OccupationResource {

    @Autowired
    private OccupationService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Occupation> find(@PathVariable Integer id) {
        Occupation obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}