package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.UsuarioDTO;
import com.projeto.ReFood.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }
    @GetMapping("/{id_usuario}")
    public ResponseEntity<UsuarioDTO> getUserById(@PathVariable int id_usuario){
        UsuarioDTO usuarioDTO = usuarioService.getUserById(id_usuario);
        
        return usuarioDTO != null ? ResponseEntity.ok(usuarioDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.createUsuario(usuarioDTO);
    }
    
    @PutMapping("/{id_usuario}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable int id_usuario, @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO updateUsuario = usuarioService.updateUsuario(id_usuario, usuarioDTO);
        
        return updateUsuario != null ? ResponseEntity.ok(updateUsuario) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id_usuario){
        usuarioService.deleteUsuario(id_usuario);
        
        return ResponseEntity.noContent().build();
    }
}
