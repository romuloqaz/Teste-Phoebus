package com.phoebus.pandemic.test.teste_phoebus.services;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public ObjectNotFoundException (String msg) {
        super(msg);
    }
}