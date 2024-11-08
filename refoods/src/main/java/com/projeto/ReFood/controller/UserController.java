package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.UserDTO;
import com.projeto.ReFood.dto.UserUpdateResponse;
import com.projeto.ReFood.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<UserDTO>> listAllUsers() {
    List<UserDTO> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }

  @GetMapping
  public ResponseEntity<UserDTO> getUserById(@RequestHeader("Authorization") String token) {
    UserDTO userDTO = userService.getUserById(token);
    return ResponseEntity.ok(userDTO);
  }

  @PostMapping
  public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
    UserDTO createdUser = userService.createUser(userDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{userId}")
        .buildAndExpand(createdUser.userId())
        .toUri();
    return ResponseEntity.created(location).body(createdUser);
  }

  @PutMapping
  public ResponseEntity<UserUpdateResponse> updateUser(@RequestHeader("Authorization") String token, @Valid @RequestBody UserDTO userDTO) {
    UserUpdateResponse updatedUser = userService.updateUser(token, userDTO);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping
  public ResponseEntity<Void> deleteUser(@RequestHeader("Authorization") String token) {
    userService.deleteUser(token);
    return ResponseEntity.noContent().build();
  }
}
