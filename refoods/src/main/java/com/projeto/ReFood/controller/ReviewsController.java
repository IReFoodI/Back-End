package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ReviewsDTO;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {
    
    @Autowired
    private ReviewsService reviewsService;
    
    @GetMapping
    public List<ReviewsDTO> getAllReviews() {
        return reviewsService.getAllReviews();
    }
    
    @GetMapping("/{id_reviews}")
    public ResponseEntity<ReviewsDTO> getReviewsById(@PathVariable int id_reviews) {
        ReviewsDTO reviewsDTO = reviewsService.getReviewsById(id_reviews);
        
        return reviewsDTO != null ? ResponseEntity.ok(reviewsDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ReviewsDTO createReviews(@RequestBody ReviewsDTO reviewsDTO) {
        return reviewsService.createReviews(reviewsDTO);
    }
    
    @PutMapping("/{id_reviews}")
    public ResponseEntity<ReviewsDTO> updateReviews(@PathVariable int id_reviews, @RequestBody ReviewsDTO reviewsDTO) {
        ReviewsDTO updateReviews = reviewsService.updateReviews(id_reviews, reviewsDTO);
        
        return updateReviews != null ? ResponseEntity.ok(updateReviews) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_reviews}")
    public ResponseEntity<Void> deleteReviews(@PathVariable int id_reviews) {
        reviewsService.deleteReviews(id_reviews);
        
        return ResponseEntity.noContent().build();
    }
}
