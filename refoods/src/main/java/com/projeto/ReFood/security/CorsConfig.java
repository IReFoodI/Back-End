package com.projeto.ReFood.security;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // Allows requests to all endpoints
        .allowedOrigins("*") // Allows requests from any origin
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed methods
        .allowedHeaders("*"); // Allowed headers
  }
}
