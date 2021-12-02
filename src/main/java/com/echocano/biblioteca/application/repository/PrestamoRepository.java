package com.echocano.biblioteca.application.repository;

import com.echocano.biblioteca.domain.Prestamo;

public interface PrestamoRepository {
    Prestamo findById(Long id);
    Prestamo findByIdentificacionUsuario(String identificacionUsuario);
    Prestamo save(Prestamo prestamo);
}
