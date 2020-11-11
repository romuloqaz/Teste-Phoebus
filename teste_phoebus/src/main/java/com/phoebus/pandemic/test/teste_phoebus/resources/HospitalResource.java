package com.phoebus.pandemic.test.teste_phoebus.resources;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.domain.HospitalDTO;
import com.phoebus.pandemic.test.teste_phoebus.domain.Resources;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;
import com.phoebus.pandemic.test.teste_phoebus.services.HospitalService;
import com.phoebus.pandemic.test.teste_phoebus.services.ResourceService;
import com.phoebus.pandemic.test.teste_phoebus.services.UpdateHospital;
import com.phoebus.pandemic.test.teste_phoebus.services.validation.utils.BR;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/hospitais")
public class HospitalResource {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private HospitalRepository hospitalRepository;

    @ApiOperation(value="Lista todos os hospitais")
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Hospital>>findAll() {
        List<Hospital> list = hospitalService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value="Busca hospital por id")
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Hospital> find(@PathVariable Integer id) {
        Hospital obj = hospitalService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value="Busca quantidade media de recursos em hospitais informando o id do recurso")
    @RequestMapping(value = "/media/{id}", method=RequestMethod.GET)
    public ResponseEntity<Float> countHospitals(@PathVariable Integer id) {
        Resources obj = resourceService.find(id);
        Float hospital = hospitalService.countHospital();
        Float resource = hospitalService.countResources(obj.getName());
        Float countResource = resource/hospital;
        return ResponseEntity.ok().body(countResource);
    }

    @ApiOperation(value="Insere Hospital")
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Hospital obj) {
        if (BR.isValidCNPJ(obj.getCnpj())){
            obj = hospitalService.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value="Atualiza ocupação do hospital")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<HospitalDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid UpdateHospital updateHospital) {
        Hospital hospital= hospitalService.find(id);
        if (hospital != null) {
            updateHospital.update(id, hospitalRepository);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value="Busca hospital com capacidade maior que 90%")
    @RequestMapping(value = "/maior", method=RequestMethod.GET)
    public List<Hospital> findHighHospital() {
        List<Hospital> list = hospitalService.higherHospital();
        return list;
    }

    @ApiOperation(value="Busca hospital com capacidade menor que 90%")
    @RequestMapping(value = "/menor", method=RequestMethod.GET)
    public List<Hospital> findMinorHospital() {
        List<Hospital> list = hospitalService.minorHospital();
        return list;
    }

    @ApiOperation(value="Busca hospital com capacidade menor que 90% a mais tempo")
    @RequestMapping(value = "/capacidadeMenor", method=RequestMethod.GET)
    public List<Hospital> longerOccupation() {
        List<Hospital> list = hospitalService.longerOccupation();
        return list;
    }

    @ApiOperation(value="Busca hospital com capacidade maior que 90% a mais tempo")
    @RequestMapping(value = "/capacidadeMaior", method=RequestMethod.GET)
    public List<Hospital> higherOccupation() {
        List<Hospital> list = hospitalService.higherOccupation();
        return list;
    }

}