package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.UserDTO;
import com.projeto.ReFood.dto.UserUpdateResponse;
import com.projeto.ReFood.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Listar todos os usuários", description = "Retorna uma lista com todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuários obtida com sucesso")
    })
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> listAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Obter usuário por ID", description = "Retorna informações do usuário com base no token de autorização")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário obtido com sucesso")
    })
    @GetMapping
    public ResponseEntity<UserDTO> getUserById(@RequestHeader("Authorization") String token) {
        UserDTO userDTO = userService.getUserById(token);
        return ResponseEntity.ok(userDTO);
    }

    @Operation(summary = "Criar usuário", description = "Cria um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso")
    })
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(createdUser.userId())
                .toUri();
        return ResponseEntity.created(location).body(createdUser);
    }

    @Operation(summary = "Atualizar usuário", description = "Atualiza um usuário existente com base no token de autorização")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    })
    @PutMapping
    public ResponseEntity<UserUpdateResponse> updateUser(@RequestHeader("Authorization") String token, @Valid @RequestBody UserDTO userDTO) {
        UserUpdateResponse updatedUser = userService.updateUser(token, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @Operation(summary = "Excluir usuário", description = "Exclui um usuário com base no token de autorização")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestHeader("Authorization") String token) {
        userService.deleteUser(token);
        return ResponseEntity.noContent().build();
    }


}
