package com.echocano.biblioteca.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class PrestamoDto {

    private Long id;
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechaMaximaDevolucion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Date getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(Date fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
}
