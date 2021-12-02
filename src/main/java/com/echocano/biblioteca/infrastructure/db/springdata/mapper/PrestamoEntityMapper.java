package com.echocano.biblioteca.infrastructure.db.springdata.mapper;

import com.echocano.biblioteca.domain.Prestamo;
import com.echocano.biblioteca.infrastructure.db.springdata.dbo.PrestamoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrestamoEntityMapper {
    Prestamo toDomain(PrestamoEntity prestamoEntity);
    PrestamoEntity toDbo(Prestamo prestamo);
}
