package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.FavoriteDTO;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    
    @Autowired
    private FavoriteService favoriteService;
    
    @GetMapping
    public List<FavoriteDTO> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }
    
    @GetMapping("/{id_favorite}")
    public ResponseEntity<FavoriteDTO> getFavoriteById(@PathVariable int id_favorite) {
        FavoriteDTO favoriteDTO = favoriteService.getFavoriteById(id_favorite);
        
        return favoriteDTO != null ? ResponseEntity.ok(favoriteDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public FavoriteDTO createFavorite(@RequestBody FavoriteDTO favoriteDTO) {
        return favoriteService.createFavorite(favoriteDTO);
    }
    
    @PutMapping("/{id_favorite}")
    public ResponseEntity<FavoriteDTO> updateFavorite(@PathVariable int id_favorite, @RequestBody FavoriteDTO favoriteDTO) {
        FavoriteDTO updateFavorite = favoriteService.updateFavorite(id_favorite, favoriteDTO);
        
        return updateFavorite != null ? ResponseEntity.ok(updateFavorite) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_favorite}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable int id_favorite) {
        favoriteService.deleteFavorite(id_favorite);
        
        return ResponseEntity.noContent().build();
    }
}
