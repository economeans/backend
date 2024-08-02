package com.gapjincoup.economeans.security.config;

import com.gapjincoup.economeans.security.HttpCookieOAuth2AuthorizationRequestRepository;
import com.gapjincoup.economeans.security.handler.OAuth2AuthenticationFailureHandler;
import com.gapjincoup.economeans.security.handler.OAuth2AuthenticationSuccessHandler;
import com.gapjincoup.economeans.security.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private final OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.addExposedHeader("*");
        configuration.addAllowedOriginPattern("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);

        return configurationSource;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(authorizeHttpRequests -> {
            authorizeHttpRequests.requestMatchers(HttpMethod.POST, "/**").permitAll();
            authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/**").permitAll();
            authorizeHttpRequests.requestMatchers(HttpMethod.PUT, "/**").permitAll();
            authorizeHttpRequests.requestMatchers(HttpMethod.PATCH, "/**").permitAll();
            authorizeHttpRequests.requestMatchers(HttpMethod.DELETE, "/**").permitAll();
            authorizeHttpRequests.requestMatchers("/oauth2/authorization/*").permitAll();

            authorizeHttpRequests.anyRequest().authenticated();
        });

        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF Disable
                .cors(cors ->
                        cors.configurationSource(corsConfigurationSource())) // CORS 설정
                .formLogin(AbstractHttpConfigurer::disable) // formLogin Disable

                // 세션 기반 인증 사용 하지 않는다.
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http
                .oauth2Login(configure ->
                        configure.authorizationEndpoint(config -> config
                                        .baseUri("/oauth2/authorization")
                                        .authorizationRequestRepository(httpCookieOAuth2AuthorizationRequestRepository))
                                .userInfoEndpoint(config -> config.userService(customOAuth2UserService))
                                .successHandler(oAuth2AuthenticationSuccessHandler)
                                .failureHandler(oAuth2AuthenticationFailureHandler)
                );


        return http.build();
    }
}
