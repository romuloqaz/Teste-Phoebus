package com.phoebus.pandemic.test.teste_phoebus.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Negotiation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date dateNegociation;
    private List<Hospital> hospitals = new ArrayList<>();
    private List<Resources> resources = new ArrayList<>();

    public Negotiation() {
    }

    public Negotiation(Integer id, Date dateNegociation) {
        this.id = id;
        this.dateNegociation = dateNegociation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateNegociation() {
        return dateNegociation;
    }

    public void setDateNegociation(Date dateNegociation) {
        this.dateNegociation = dateNegociation;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Resources> getResources() {
        return resources;
    }

    public void setResources(List<Resources> resources) {
        this.resources = resources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Negotiation that = (Negotiation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
