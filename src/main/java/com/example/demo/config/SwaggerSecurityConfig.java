package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Merit API", version = "v1"),
        security = { @SecurityRequirement(name = "bearerAuth") } // <-- aplica globalmente
)
@SecurityScheme(
        name = "bearerAuth",                  // <-- NOME TEM QUE BATER COM O DE CIMA
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerSecurityConfig {}
