package com.echocano.biblioteca.infrastructure.rest.spring.resources;

import com.echocano.biblioteca.application.service.PrestamoService;
import com.echocano.biblioteca.infrastructure.rest.spring.dto.PrestamoDto;
import com.echocano.biblioteca.infrastructure.rest.spring.mapper.PrestamoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PrestamoControlador {

    private final PrestamoService prestamoService;
    private final PrestamoMapper prestamoMapper;

    public PrestamoControlador(PrestamoService prestamoService, PrestamoMapper prestamoMapper) {
        this.prestamoService = prestamoService;
        this.prestamoMapper = prestamoMapper;
    }

    @PostMapping(value="/prestamo", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Object> create(@RequestBody PrestamoDto prestamoDto){
        try {
            return new ResponseEntity<>(prestamoMapper.toDto(prestamoService.save(prestamoMapper.toDomain(prestamoDto))),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("mensaje", e.getMessage());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/prestamo/{id-prestamo}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Object> getPrestamoById(@PathVariable("id-prestamo") Long id) {
        try {
            return new ResponseEntity<>(prestamoMapper.toDto(prestamoService.getPrestamo(id)), HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("mensaje", e.getMessage());
            return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
        }
    }
}

