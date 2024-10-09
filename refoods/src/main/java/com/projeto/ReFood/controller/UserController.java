package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.UserDTO;
import com.projeto.ReFood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<UserDTO> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id_user}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable int id_user) {
    UserDTO userDTO = userService.getUserById(id_user);

    return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
    UserDTO createdUser = userService.createUser(userDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
  }

  @PutMapping("/{id_user}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable int id_user, @RequestBody UserDTO userDTO) {
    UserDTO updateUser = userService.updateUser(id_user, userDTO);

    return updateUser != null ? ResponseEntity.ok(updateUser) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id_user}")
  public ResponseEntity<Void> deleteUser(@PathVariable int id_user) {
    userService.deleteUser(id_user);

    return ResponseEntity.noContent().build();
  }
}
