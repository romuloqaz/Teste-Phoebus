package com.phoebus.pandemic.test.teste_phoebus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Hospital implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    private String name;

    @CNPJ
    @Column(unique=true)
    @NotEmpty(message="Preenchimento obrigatório")
    private String cnpj;

    @NotEmpty(message="Preenchimento obrigatório")
    private String number;

    @NotEmpty(message="Preenchimento obrigatório")
    private String cep;

    @NotEmpty(message="Preenchimento obrigatório")
    private String street;

    @NotEmpty(message="Preenchimento obrigatório")
    private String city;

    @NotEmpty(message="Preenchimento obrigatório")
    private String state;

    private double latitude;
    private double longitude;

    @Max(100)
    @Min(0)
    private Double average;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dateUpdate;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "HOSPITAL_RESOURCES",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name= "resources_id")
    )
    private List<Resources> resources = new ArrayList<>();

    public Hospital() {
    }

    public Hospital(Integer id, String name, String cnpj, String number, String cep, String street, String city,
                    String state, double latitude, double longitude, Double average, Date dateUpdate) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.number = number;
        this.cep = cep;
        this.street = street;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.average = average;
        this.dateUpdate = dateUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

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
        Hospital hospital = (Hospital) o;
        return id.equals(hospital.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
