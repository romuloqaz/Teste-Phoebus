package com.phoebus.pandemic.test.teste_phoebus.resources;

import com.phoebus.pandemic.test.teste_phoebus.domain.Resources;
import com.phoebus.pandemic.test.teste_phoebus.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/resources")
public class ResourcesResource {

    @Autowired
    private ResourceService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Resources> find(@PathVariable Integer id) {
        Resources obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}