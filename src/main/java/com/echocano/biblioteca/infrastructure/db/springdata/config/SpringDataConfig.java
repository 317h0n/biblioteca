package com.echocano.biblioteca.infrastructure.db.springdata.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.echocano.biblioteca.infrastructure.db.springdata.repository")
@ConfigurationProperties("spring.datasource")
@EnableJpaAuditing
@EntityScan(basePackages = "com.echocano.biblioteca.infrastructure.db.springdata.dbo")
public class SpringDataConfig {
}
