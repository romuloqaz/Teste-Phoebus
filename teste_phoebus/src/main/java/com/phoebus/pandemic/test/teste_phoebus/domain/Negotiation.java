package com.phoebus.pandemic.test.teste_phoebus.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Negotiation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date dateNegociation;
    private List<Hospital> hospitals = new ArrayList<>();
    private List<Resources> resources = new ArrayList<>();

}
