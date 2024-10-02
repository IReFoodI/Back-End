package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ReviewsDTO;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class ReviewsController {
    
    @Autowired
    private ReviewsService reviewsService;
    
    @GetMapping
    public List<ReviewsDTO> getAllAvaliacoes() {
        return reviewsService.getAllAvaliacoes();
    }
    
    @GetMapping("/{id_avaliacao}")
    public ResponseEntity<ReviewsDTO> getAvaliacaoById(@PathVariable int id_avaliacao) {
        ReviewsDTO reviewsDTO = reviewsService.getAvaliacaoById(id_avaliacao);
        
        return reviewsDTO != null ? ResponseEntity.ok(reviewsDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ReviewsDTO createAvaliacao(@RequestBody ReviewsDTO reviewsDTO) {
        return reviewsService.createAvaliacao(reviewsDTO);
    }
    
    @PutMapping("/{id_avaliacao}")
    public ResponseEntity<ReviewsDTO> updateAvaliacao(@PathVariable int id_avaliacao, @RequestBody ReviewsDTO reviewsDTO) {
        ReviewsDTO updateAvaliacao = reviewsService.updateAvaliacao(id_avaliacao, reviewsDTO);
        
        return updateAvaliacao != null ? ResponseEntity.ok(updateAvaliacao) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_avaliacao}")
    public ResponseEntity<Void> deleteAvaliacao(@PathVariable int id_avaliacao) {
        reviewsService.deleteAvaliacao(id_avaliacao);
        
        return ResponseEntity.noContent().build();
    }
}
