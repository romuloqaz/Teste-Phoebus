package com.phoebus.pandemic.test.teste_phoebus.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Resources implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    private String name;

    private Integer valueResource;

    @ManyToMany(mappedBy = "resources")
    private List<Hospital> hospitals = new ArrayList<>();

    public Resources() {
    }

    public Resources(Integer id, String name, Integer valueResource) {
        this.id = id;
        this.name = name;
        this.valueResource = valueResource;
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

    public Integer getValueResource() {
        return valueResource;
    }

    public void setValueResource(Integer valueResource) {
        this.valueResource = valueResource;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resources resources = (Resources) o;
        return Objects.equals(id, resources.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
