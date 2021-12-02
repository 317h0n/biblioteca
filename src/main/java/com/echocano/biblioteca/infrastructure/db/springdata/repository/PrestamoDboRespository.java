package com.echocano.biblioteca.infrastructure.db.springdata.repository;

import com.echocano.biblioteca.application.repository.PrestamoRepository;
import com.echocano.biblioteca.domain.Prestamo;
import com.echocano.biblioteca.infrastructure.db.springdata.mapper.PrestamoEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class PrestamoDboRespository implements PrestamoRepository {

    private final SpringDataPrestamoRepository prestamoRepository;

    private final PrestamoEntityMapper prestamoMapper;

    public PrestamoDboRespository(SpringDataPrestamoRepository prestamoRepository, PrestamoEntityMapper prestamoMapper) {
        this.prestamoRepository = prestamoRepository;
        this.prestamoMapper = prestamoMapper;
    }

    @Override
    public Prestamo findById(Long id) {
        return prestamoMapper.toDomain(prestamoRepository.findById(id).orElse(null));
    }

    @Override
    public Prestamo findByIdentificacionUsuario(String identificacionUsuario) {
        return prestamoMapper.toDomain(prestamoRepository.findByIdentificacionUsuario(identificacionUsuario).orElse(null));
    }

    @Override
    public Prestamo save(Prestamo prestamo) {
        return prestamoMapper.toDomain(prestamoRepository.save(prestamoMapper.toDbo(prestamo)));
    }
}
