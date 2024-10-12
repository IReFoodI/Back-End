package com.projeto.ReFood.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.projeto.ReFood.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity // 3333333333333333
public class SecurityConfig {
  private final JwtAuthenticationFilter jwtAuthFilter;
  private final CustomUserDetailsService customUserDetailsService;

  public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter,
      CustomUserDetailsService customUserDetailsService) {
    this.jwtAuthFilter = jwtAuthFilter;
    this.customUserDetailsService = customUserDetailsService;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(customUserDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  @Profile("test")
  @Order(1)
  public SecurityFilterChain h2SecurityFilterChain(HttpSecurity http) throws Exception {
    http.securityMatcher(PathRequest.toH2Console())
        .csrf(csrf -> csrf.disable())
        .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
    return http.build();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/**").permitAll() // login
            .requestMatchers("/h2-console/**").permitAll() // h2 database
            .requestMatchers("/", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // swagger
            .requestMatchers(HttpMethod.GET, "/user").hasRole("USER") 
            .requestMatchers(HttpMethod.GET, "/restaurant").hasRole("RESTAURANT") // apenas uma rota para testar autenticação
            .requestMatchers(HttpMethod.POST, "/api/user").permitAll() // create user
            .requestMatchers(HttpMethod.POST, "/api/restaurant").permitAll() // create restaurant
            .anyRequest().permitAll() // To permitindo todas as requisições temporariamente para teste
            // .anyRequest().authenticated() // Bloqueia todas as outras requisições
        )
        .authenticationProvider(authenticationProvider())
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

}
