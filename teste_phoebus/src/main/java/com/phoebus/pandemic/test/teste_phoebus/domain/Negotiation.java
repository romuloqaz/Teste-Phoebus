package com.phoebus.pandemic.test.teste_phoebus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Negotiation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateNegociation;

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
