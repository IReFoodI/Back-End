// package com.projeto.ReFood.controller;

// import com.projeto.ReFood.service.FavoriteService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import com.projeto.ReFood.dto.FavoriteDTO;

// import java.util.List;

// @RestController
// @RequestMapping("/api/favoritos")
// public class FavoriteController {
    
//     @Autowired
//     private FavoriteService favoriteService;
    
//     @GetMapping
//     public List<FavoriteDTO> getAllFavoritos() {
//         return favoriteService.getAllFavoritos();
//     }
    
//     @GetMapping("/{id_favorito}")
//     public ResponseEntity<FavoriteDTO> getFavoritoById(@PathVariable int id_favorito) {
//         FavoriteDTO favoriteDTO = favoriteService.getFavoritoById(id_favorito);
        
//         return favoriteDTO != null ? ResponseEntity.ok(favoriteDTO) : ResponseEntity.notFound().build();
//     }
    
//     @PostMapping
//     public FavoriteDTO createFavorito(@RequestBody FavoriteDTO favoriteDTO) {
//         return favoriteService.createFavorito(favoriteDTO);
//     }
    
//     @PutMapping("/{id_favorito}")
//     public ResponseEntity<FavoriteDTO> updateFavorito(@PathVariable int id_favorito, @RequestBody FavoriteDTO favoriteDTO) {
//         FavoriteDTO updateFavorito = favoriteService.updateFavorito(id_favorito, favoriteDTO);
        
//         return updateFavorito != null ? ResponseEntity.ok(updateFavorito) : ResponseEntity.notFound().build();
//     }
    
//     @DeleteMapping("/{id_favorito}")
//     public ResponseEntity<Void> deleteFavorito(@PathVariable int id_favorito) {
//         favoriteService.deleteFavorito(id_favorito);
        
//         return ResponseEntity.noContent().build();
//     }
// }
