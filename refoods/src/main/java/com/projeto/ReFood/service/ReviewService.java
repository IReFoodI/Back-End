package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.ReviewDTO;
import com.projeto.ReFood.model.Review;
import com.projeto.ReFood.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewsRepository;
    
    public List<ReviewDTO> getAllReviews(){
        return reviewsRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ReviewDTO getReviewById(int id_review){
        Optional<Review> reviews = reviewsRepository.findById(id_review);
        return reviews.map(this::convertToDTO).orElse(null);
    }
    
    public ReviewDTO createReviews(ReviewDTO reviewsDTO){
      Review reviews = new Review();
        
        reviews.setRating_note(reviewsDTO.getRating_note());
        reviews.setRating_date(reviewsDTO.getRating_date());
        reviews.setRating_comment(reviewsDTO.getRating_comment());
        reviewsRepository.save(reviews);
        return convertToDTO(reviews);
    }
    
    public ReviewDTO updateReviews(int id_review, ReviewDTO reviewsDTO){
        Optional<Review> reviewsOptional = reviewsRepository.findById(id_review);
        
        if(reviewsOptional.isPresent()){
          Review reviews = reviewsOptional.get();

            reviews.setRating_note(reviewsDTO.getRating_note());
            reviews.setRating_date(reviewsDTO.getRating_date());
            reviews.setRating_comment(reviewsDTO.getRating_comment());
            reviewsRepository.save(reviews);
            
            return convertToDTO(reviews);
        }
        
        return null;
    }
    
    public void deleteReviews(int id_review){
        reviewsRepository.deleteById(id_review);
    }
    
    private ReviewDTO convertToDTO(Review reviews){
        ReviewDTO reviewsDTO = new ReviewDTO();
        
        reviewsDTO.setId_review(reviews.getId_review());
        reviewsDTO.setRating_note(reviews.getRating_note());
        reviewsDTO.setRating_date(reviews.getRating_date());
        reviewsDTO.setRating_comment(reviews.getRating_comment());
        
        return reviewsDTO;
    }
}