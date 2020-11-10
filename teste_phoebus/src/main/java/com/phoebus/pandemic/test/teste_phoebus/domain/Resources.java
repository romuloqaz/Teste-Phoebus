package com.phoebus.pandemic.test.teste_phoebus.domain;


import java.io.Serializable;
import java.util.Objects;

public class Resources implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer valueResource;

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
