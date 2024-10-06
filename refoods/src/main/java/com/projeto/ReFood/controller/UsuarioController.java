package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.UserDTO;
import com.projeto.ReFood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private UserService usuarioService;
    
    @GetMapping
    public List<UserDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }
    @GetMapping("/{id_usuario}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id_usuario){
        UserDTO usuarioDTO = usuarioService.getUserById(id_usuario);
        
        return usuarioDTO != null ? ResponseEntity.ok(usuarioDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public UserDTO createUsuario(@RequestBody UserDTO usuarioDTO){
        return usuarioService.createUsuario(usuarioDTO);
    }
    
    @PutMapping("/{id_usuario}")
    public ResponseEntity<UserDTO> updateUsuario(@PathVariable int id_usuario, @RequestBody UserDTO usuarioDTO){
        UserDTO updateUsuario = usuarioService.updateUsuario(id_usuario, usuarioDTO);
        
        return updateUsuario != null ? ResponseEntity.ok(updateUsuario) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id_usuario){
        usuarioService.deleteUsuario(id_usuario);
        
        return ResponseEntity.noContent().build();
    }
}
