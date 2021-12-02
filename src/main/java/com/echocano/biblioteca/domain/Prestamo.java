package com.echocano.biblioteca.domain;

import java.util.Date;

public class Prestamo {

    public static final int USUARIO_AFILIADO = 1;
    public static final int USUARIO_EMPLEADO = 2;
    public static final int USUARIO_INVITADO = 3;

    private Long id;
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
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

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", identificacionUsuario='" + identificacionUsuario + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", fechaMaximaDevolucion=" + fechaMaximaDevolucion +
                '}';
    }
}
