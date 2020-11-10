package com.phoebus.pandemic.test.teste_phoebus.domain;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String number;
    private String cep;
    private String street;
    private String city;
    private String state;
    private double latitude;
    private double longitude;

}
