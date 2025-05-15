package com.peso.elBuenSabor.config;


import com.peso.elBuenSabor.JWT.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                                authRequest
                                        //Autenticacion
                                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/elbuensabor/**")).permitAll()

                                        //Consola H2:
                                        .requestMatchers(PathRequest.toH2Console()).permitAll()

                                        //Autorizacion de acceso a la url:
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/demoAdmin/**")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/demoUser/**")).hasAuthority("USER")
                                        .requestMatchers(new AntPathRequestMatcher("/elbuensabor/v1/articulosmanufacturados")).hasAuthority("ADMIN")

                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

    }

