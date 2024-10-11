package com.projeto.ReFood.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.projeto.ReFood.service.CustomUserDetailsService;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // 22222222222
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String BEARER_PREFIX = "Bearer ";

  private final JwtTokenProvider jwtTokenProvider;
  private final CustomUserDetailsService customUserDetailsService;

  @Autowired
  public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, CustomUserDetailsService customUserDetailsService) {
    this.jwtTokenProvider = jwtTokenProvider;
    this.customUserDetailsService = customUserDetailsService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String authHeader = request.getHeader(AUTHORIZATION_HEADER);
    System.out.println("===============================");
    System.out.println("Auth Header: " + authHeader); // Log do cabeçalho
    System.out.println("===============================");

    if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
      filterChain.doFilter(request, response);
      return;
    }

    String jwt = authHeader.substring(BEARER_PREFIX.length());
    System.out.println("===============================");
    System.out.println("JWT Token: " + jwt); // Log do token
    System.out.println("===============================");
    String username = jwtTokenProvider.extractUsername(jwt);
    System.out.println("===============================");
    System.out.println("Username: " + username); // Log do nome de usuário
    System.out.println("===============================");

    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      authenticateUser(request, response, jwt, username);
    }

    filterChain.doFilter(request, response);
  }

  private void authenticateUser(HttpServletRequest request, HttpServletResponse response, String jwt, String username)
      throws IOException {
    try {
      UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

      if (jwtTokenProvider.isTokenValid(jwt, userDetails)) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        System.out.println("===============================");
        System.out.println("Authorities: " + userDetails.getAuthorities()); // Log para verificar as authorities
        System.out.println("===============================");
      }
    } catch (UsernameNotFoundException e) {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuário não encontrado");
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
    }
  }
}
