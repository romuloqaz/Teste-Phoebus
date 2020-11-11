package com.phoebus.pandemic.test.teste_phoebus.resources;

import com.phoebus.pandemic.test.teste_phoebus.domain.Resources;
import com.phoebus.pandemic.test.teste_phoebus.services.ResourceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/recursos")
public class ResourcesResource {

    @Autowired
    private ResourceService service;

    @ApiOperation(value="Busca recurso por id")
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Resources> find(@PathVariable Integer id) {
        Resources obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value="Insere recursos")
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Resources obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}