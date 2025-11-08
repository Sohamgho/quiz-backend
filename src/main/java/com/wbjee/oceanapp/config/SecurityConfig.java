package com.wbjee.oceanapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**", "/actuator/**", "/health").permitAll()
                .anyRequest().permitAll() // currently allow all; add role-based rules later
            )
            .httpBasic(b -> b.disable())
            .formLogin(f -> f.disable());

        return http.build();
    }
}
