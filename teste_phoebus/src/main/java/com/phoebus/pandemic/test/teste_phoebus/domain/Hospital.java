package com.phoebus.pandemic.test.teste_phoebus.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hospital implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String cnpj;
    private Address address;
    private List<Resources> resources = new ArrayList<>();
    private Occupation occupation;


}
