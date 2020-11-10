package com.phoebus.pandemic.test.teste_phoebus.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Hospital implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "hospital")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "hospital")
    private Occupation occupation;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "HOSPITAL_RESOURCES",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name= "resources_id")
    )
    private List<Resources> resources = new ArrayList<>();


    public Hospital() {
    }

    public Hospital(Integer id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
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
