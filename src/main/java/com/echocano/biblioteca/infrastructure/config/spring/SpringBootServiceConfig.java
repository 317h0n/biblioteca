package com.echocano.biblioteca.infrastructure.config.spring;

import com.echocano.biblioteca.application.repository.PrestamoRepository;
import com.echocano.biblioteca.application.service.PrestamoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServiceConfig {

    @Bean
    public PrestamoService prestamoService(PrestamoRepository prestamoRepository) {
        return new PrestamoService(prestamoRepository);
    }
}
