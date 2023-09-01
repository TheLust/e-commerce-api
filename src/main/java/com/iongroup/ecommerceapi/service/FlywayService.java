package com.iongroup.ecommerceapi.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlywayService {

    private final Flyway flyway;

    @PostConstruct
    public void migrateScript() {
        flyway.migrate();
    }
}
