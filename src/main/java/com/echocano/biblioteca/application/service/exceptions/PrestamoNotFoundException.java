package com.echocano.biblioteca.application.service.exceptions;

public class PrestamoNotFoundException extends RuntimeException {

    public PrestamoNotFoundException(long id) {
        super(String.format("El prestamo con ID %s no existe", id));
    }
}
