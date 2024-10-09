package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ReviewDTO;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewsService;
    
    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewsService.getAllReviews();
    }
    
    @GetMapping("/{id_review}")
    public ResponseEntity<ReviewDTO> getReviewsById(@PathVariable int id_reviews) {
        ReviewDTO reviewsDTO = reviewsService.getReviewById(id_reviews);
        
        return reviewsDTO != null ? ResponseEntity.ok(reviewsDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ReviewDTO createReviews(@RequestBody ReviewDTO reviewsDTO) {
        return reviewsService.createReviews(reviewsDTO);
    }
    
    @PutMapping("/{id_review}")
    public ResponseEntity<ReviewDTO> updateReviews(@PathVariable int id_reviews, @RequestBody ReviewDTO reviewsDTO) {
        ReviewDTO updateReviews = reviewsService.updateReviews(id_reviews, reviewsDTO);
        
        return updateReviews != null ? ResponseEntity.ok(updateReviews) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_review}")
    public ResponseEntity<Void> deleteReviews(@PathVariable int id_reviews) {
        reviewsService.deleteReviews(id_reviews);
        
        return ResponseEntity.noContent().build();
    }
}
