package com.phoebus.pandemic.test.teste_phoebus.services;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;


public class UpdateHospital {

    @Max(100)
    @Min(0)
    private Double average;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dateUpdate;


    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Hospital update(Integer id, HospitalRepository hospitalRepository) {
        Hospital hospital = hospitalRepository.getOne(id);
        hospital.setAverage(this.average);
        hospital.setDateUpdate(this.dateUpdate);
        return hospital;
    }
}