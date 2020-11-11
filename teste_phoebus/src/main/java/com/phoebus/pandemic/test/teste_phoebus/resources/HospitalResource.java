package com.phoebus.pandemic.test.teste_phoebus.resources;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.domain.HospitalDTO;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;
import com.phoebus.pandemic.test.teste_phoebus.services.HospitalService;
import com.phoebus.pandemic.test.teste_phoebus.services.UpdateHospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/hospitais")
public class HospitalResource {

    @Autowired
    private HospitalService service;

    @Autowired
    private HospitalRepository hospitalRepository;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Hospital> find(@PathVariable Integer id) {
        Hospital obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<HospitalDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid UpdateHospital updateHospital) {
        Hospital hospital= service.find(id);
        if (hospital != null) {
            updateHospital.update(id, hospitalRepository);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/maior", method=RequestMethod.GET)
    public List<Hospital> findHighHospital() {
        List<Hospital> list = service.higherHospital();
        return list;
    }

    @RequestMapping(value = "/menor", method=RequestMethod.GET)
    public List<Hospital> findMinorHospital() {
        List<Hospital> list = service.minorHospital();
        return list;
    }

}