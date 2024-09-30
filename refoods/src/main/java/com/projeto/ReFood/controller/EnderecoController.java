package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.EnderecoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;
    
    @GetMapping
    public List<EnderecoDTO> getAllEnderecos() {
        return enderecoService.getAllEnderecos();
    }
    
    @GetMapping("/{id_endereco}")
    public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable int id_endereco) {
        EnderecoDTO enderecoDTO = enderecoService.getEnderecoById(id_endereco);
        
        return enderecoDTO != null ? ResponseEntity.ok(enderecoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public EnderecoDTO createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        return enderecoService.createEndereco(enderecoDTO);
    }
    
    @PutMapping("/{id_endereco}")
    public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable int id_endereco, @RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO updateEndereco = enderecoService.updateEndereco(id_endereco, enderecoDTO);
        
        return updateEndereco != null ? ResponseEntity.ok(updateEndereco) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_endereco}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable int id_endereco) {
        enderecoService.deleteEndereco(id_endereco);
        
        return ResponseEntity.noContent().build();
    }
}
