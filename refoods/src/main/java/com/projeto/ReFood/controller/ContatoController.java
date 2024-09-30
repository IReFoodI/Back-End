package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ContatoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
    
    @Autowired
    private ContatoService contatoService;
    
    @GetMapping
    public List<ContatoDTO> getAllContatos() {
        return contatoService.getAllContatos();
    }
    
    @GetMapping("/{id_contato}")
    public ResponseEntity<ContatoDTO> getContatoById(@PathVariable int id_contato) {
        ContatoDTO contatoDTO = contatoService.getContatoById(id_contato);
        
        return contatoDTO != null ? ResponseEntity.ok(contatoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ContatoDTO createContato(@RequestBody ContatoDTO contatoDTO) {
        return contatoService.createContato(contatoDTO);
    }
    
    @PutMapping("/{id_contato}")
    public ResponseEntity<ContatoDTO> updateContato(@PathVariable int id_contato, @RequestBody ContatoDTO contatoDTO) {
        ContatoDTO updateContato = contatoService.updateContato(id_contato, contatoDTO);
        
        return updateContato != null ? ResponseEntity.ok(updateContato) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_contato}")
    public ResponseEntity<Void> deleteContato(@PathVariable int id_contato) {
        contatoService.deleteContato(id_contato);
        
        return ResponseEntity.noContent().build();
    }
}
