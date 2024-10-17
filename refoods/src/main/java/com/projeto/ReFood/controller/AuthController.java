package com.projeto.ReFood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.ReFood.dto.LoginRequest;
import com.projeto.ReFood.dto.LoginResponse;
import com.projeto.ReFood.security.JwtTokenProvider;
import com.projeto.ReFood.service.CustomUserDetailsService;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenProvider jwtTokenProvider;
  private final CustomUserDetailsService userDetailsService;

  @Autowired
  public AuthController(AuthenticationManager authenticationManager,
                        JwtTokenProvider jwtTokenProvider,
                        CustomUserDetailsService userDetailsService) {
      this.authenticationManager = authenticationManager;
      this.jwtTokenProvider = jwtTokenProvider;
      this.userDetailsService = userDetailsService;
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> createAuthenticationToken(@RequestBody LoginRequest loginRequest) {
    
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
    } catch (BadCredentialsException e) {
      return ResponseEntity
          .status(HttpStatus.UNAUTHORIZED)
          .body(new LoginResponse("Invalid credentials")); // status 401
    } catch (Exception e) {
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new LoginResponse("An error occurred")); // status 500
    }

    final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.email());
    final String jwt = jwtTokenProvider.generateToken(userDetails);

    return ResponseEntity.ok(new LoginResponse(jwt));
  }
}
