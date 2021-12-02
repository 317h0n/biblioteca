package com.echocano.biblioteca.infrastructure.rest.spring.mapper;

import com.echocano.biblioteca.domain.Prestamo;
import com.echocano.biblioteca.infrastructure.rest.spring.dto.PrestamoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {
    PrestamoDto toDto(Prestamo prestamo);
    Prestamo toDomain(PrestamoDto prestamoDto);
}
