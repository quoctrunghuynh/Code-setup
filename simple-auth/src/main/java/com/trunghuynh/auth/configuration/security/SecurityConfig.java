package com.trunghuynh.auth.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.trunghuynh.auth.entity.Permission.ADMIN_CREATE;
import static com.trunghuynh.auth.entity.Permission.ADMIN_READ;
import static com.trunghuynh.auth.entity.Permission.ADMIN_UPDATE;
import static com.trunghuynh.auth.entity.Permission.ADMIN_DELETE;
import static com.trunghuynh.auth.entity.Permission.MANAGER_CREATE;
import static com.trunghuynh.auth.entity.Permission.MANAGER_READ;
import static com.trunghuynh.auth.entity.Permission.MANAGER_UPDATE;
import static com.trunghuynh.auth.entity.Permission.MANAGER_DELETE;
import static com.trunghuynh.auth.entity.Role.ADMIN;
import static com.trunghuynh.auth.entity.Role.MANAGER;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String[] WHITE_LIST_URL ={
            "/api/auth/register",
            "/api/auth/authenticate"
    };
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests(req -> req.requestMatchers(WHITE_LIST_URL).permitAll()
                        .requestMatchers("/api/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())
                        .requestMatchers(GET, "/api/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
                        .requestMatchers(POST, "/api/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
                        .requestMatchers(PUT, "/api/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
                        .requestMatchers(DELETE, "/api/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
                        .anyRequest()
                        .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                );
        return httpSecurity.build();
    }
}
