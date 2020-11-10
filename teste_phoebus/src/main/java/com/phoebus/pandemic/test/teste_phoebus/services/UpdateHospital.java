package com.phoebus.pandemic.test.teste_phoebus.services;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class UpdateHospital {

    @Max(100)
    @Min(0)
    private Double average;

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Hospital update(Integer id, HospitalRepository hospitalRepository) {
        Hospital topico = hospitalRepository.getOne(id);
        topico.setAverage(this.average);
        return topico;
    }
}