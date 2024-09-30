package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.FavoritoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {
    
    @Autowired
    private FavoritoService favoritoService;
    
    @GetMapping
    public List<FavoritoDTO> getAllFavoritos() {
        return favoritoService.getAllFavoritos();
    }
    
    @GetMapping("/{id_favorito}")
    public ResponseEntity<FavoritoDTO> getFavoritoById(@PathVariable int id_favorito) {
        FavoritoDTO favoritoDTO = favoritoService.getFavoritoById(id_favorito);
        
        return favoritoDTO != null ? ResponseEntity.ok(favoritoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public FavoritoDTO createFavorito(@RequestBody FavoritoDTO favoritoDTO) {
        return favoritoService.createFavorito(favoritoDTO);
    }
    
    @PutMapping("/{id_favorito}")
    public ResponseEntity<FavoritoDTO> updateFavorito(@PathVariable int id_favorito, @RequestBody FavoritoDTO favoritoDTO) {
        FavoritoDTO updateFavorito = favoritoService.updateFavorito(id_favorito, favoritoDTO);
        
        return updateFavorito != null ? ResponseEntity.ok(updateFavorito) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_favorito}")
    public ResponseEntity<Void> deleteFavorito(@PathVariable int id_favorito) {
        favoritoService.deleteFavorito(id_favorito);
        
        return ResponseEntity.noContent().build();
    }
}
