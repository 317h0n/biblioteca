package com.echocano.biblioteca.application.service;

import com.echocano.biblioteca.application.repository.PrestamoRepository;
import com.echocano.biblioteca.application.service.exceptions.InvalidPrestamoException;
import com.echocano.biblioteca.application.service.exceptions.PrestamoNotFoundException;
import com.echocano.biblioteca.domain.Prestamo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PrestamoService {

    private final PrestamoRepository repository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.repository = prestamoRepository;
    }

    public Prestamo getPrestamo(Long id) {
        Prestamo prestamo = repository.findById(id);
        if (prestamo == null) {
            throw new PrestamoNotFoundException(id);
        }
        return prestamo;
    }

    public Prestamo getByIdentificacionUsuario(String identificacionUsuario) {
        return repository.findByIdentificacionUsuario(identificacionUsuario);
    }

    public Prestamo save(Prestamo prestamo) {
        String error = validarNuevoPrestamo(prestamo);
        if (error != null) {
            throw new InvalidPrestamoException(error);
        }
        prestamo.setFechaMaximaDevolucion(calcularFechaMaximaDevolucion(prestamo));
        return repository.save(prestamo);
    }

    private String validarNuevoPrestamo(Prestamo prestamo) {
        if (prestamo.getTipoUsuario() < 1 || prestamo.getTipoUsuario() > 3) {
            return "Tipo de usuario no permitido en la biblioteca";
        }
        if(prestamo.getTipoUsuario() == Prestamo.USUARIO_INVITADO) {
            Prestamo anterior = getByIdentificacionUsuario(prestamo.getIdentificacionUsuario());
            if (anterior != null) {
                return String.format("El usuario con identificación %s ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo", prestamo.getIdentificacionUsuario());
            }
        }
        return null;
    }

    private Date calcularFechaMaximaDevolucion(Prestamo prestamo) {
        LocalDate fechaPrestamo = LocalDate.now();
        switch (prestamo.getTipoUsuario()) {
            case Prestamo.USUARIO_AFILIADO:
                fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 10);
                break;
            case Prestamo.USUARIO_EMPLEADO:
                fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 8);
                break;
            case Prestamo.USUARIO_INVITADO:
                fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 7);
                break;
            default:
                fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 7);
                break;
        }
        return convertToDateViaInstant(fechaPrestamo);
    }

    public LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
