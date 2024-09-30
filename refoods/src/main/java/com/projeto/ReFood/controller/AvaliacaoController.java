package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.AvaliacaoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {
    
    @Autowired
    private AvaliacaoService avaliacaoService;
    
    @GetMapping
    public List<AvaliacaoDTO> getAllAvaliacoes() {
        return avaliacaoService.getAllAvaliacoes();
    }
    
    @GetMapping("/{id_avaliacao}")
    public ResponseEntity<AvaliacaoDTO> getAvaliacaoById(@PathVariable int id_avaliacao) {
        AvaliacaoDTO avaliacaoDTO = avaliacaoService.getAvaliacaoById(id_avaliacao);
        
        return avaliacaoDTO != null ? ResponseEntity.ok(avaliacaoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public AvaliacaoDTO createAvaliacao(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        return avaliacaoService.createAvaliacao(avaliacaoDTO);
    }
    
    @PutMapping("/{id_avaliacao}")
    public ResponseEntity<AvaliacaoDTO> updateAvaliacao(@PathVariable int id_avaliacao, @RequestBody AvaliacaoDTO avaliacaoDTO) {
        AvaliacaoDTO updateAvaliacao = avaliacaoService.updateAvaliacao(id_avaliacao, avaliacaoDTO);
        
        return updateAvaliacao != null ? ResponseEntity.ok(updateAvaliacao) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_avaliacao}")
    public ResponseEntity<Void> deleteAvaliacao(@PathVariable int id_avaliacao) {
        avaliacaoService.deleteAvaliacao(id_avaliacao);
        
        return ResponseEntity.noContent().build();
    }
}
