package com.gapjincoup.economeans.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(authorizeHttpRequests -> {
            authorizeHttpRequests.requestMatchers(HttpMethod.POST, "/**").permitAll();
            authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/**").permitAll();
            authorizeHttpRequests.requestMatchers(HttpMethod.PUT, "/**").permitAll();
            authorizeHttpRequests.requestMatchers(HttpMethod.PATCH, "/**").permitAll();
            authorizeHttpRequests.requestMatchers(HttpMethod.DELETE, "/**").permitAll();

            authorizeHttpRequests.anyRequest().authenticated();
        });

        return http.build();
    }
}
