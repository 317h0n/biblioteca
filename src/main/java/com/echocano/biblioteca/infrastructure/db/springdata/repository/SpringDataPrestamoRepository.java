package com.echocano.biblioteca.infrastructure.db.springdata.repository;

import com.echocano.biblioteca.application.repository.PrestamoRepository;
import com.echocano.biblioteca.infrastructure.db.springdata.dbo.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataPrestamoRepository extends JpaRepository<PrestamoEntity, Long> {

    Optional<PrestamoEntity> findByIdentificacionUsuario(String identificacionUsuario);

}
