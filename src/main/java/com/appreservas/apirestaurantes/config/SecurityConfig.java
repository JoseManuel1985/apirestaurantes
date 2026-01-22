package com.appreservas.apirestaurantes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Clase de configuración de seguridad de Spring Security
 * Define las políticas de seguridad para la aplicación REST de restaurantes
 */
@Configuration
public class SecurityConfig {

    /**
     * Configura la cadena de filtros de seguridad HTTP
     *
     * - Deshabilita la protección CSRF (recomendado para APIs REST stateless)
     * - Permite todas las peticiones HTTP sin autenticación
     *
     * @param http objeto HttpSecurity para configurar la seguridad
     * @return SecurityFilterChain configurada
     * @throws Exception si hay errores en la configuración
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}

