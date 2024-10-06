package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.ReviewsDTO;
import com.projeto.ReFood.model.Reviews;
import com.projeto.ReFood.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewsService {
    
    @Autowired
    private ReviewsRepository reviewsRepository;
    
    public List<ReviewsDTO> getAllReviews(){
        return reviewsRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ReviewsDTO getReviewsById(int id_reviews){
        Optional<Reviews> reviews = reviewsRepository.findById(id_reviews);
        return reviews.map(this::convertToDTO).orElse(null);
    }
    
    public ReviewsDTO createReviews(ReviewsDTO reviewsDTO){
      Reviews reviews = new Reviews();
        
        reviews.setRating_note(reviewsDTO.getRating_note());
        reviews.setRating_date(reviewsDTO.getRating_date());
        reviews.setRating_comment(reviewsDTO.getRating_comment());
        reviewsRepository.save(reviews);
        return convertToDTO(reviews);
    }
    
    public ReviewsDTO updateReviews(int id_reviews, ReviewsDTO reviewsDTO){
        Optional<Reviews> reviewsOptional = reviewsRepository.findById(id_reviews);
        
        if(reviewsOptional.isPresent()){
          Reviews reviews = reviewsOptional.get();

            reviews.setRating_note(reviewsDTO.getRating_note());
            reviews.setRating_date(reviewsDTO.getRating_date());
            reviews.setRating_comment(reviewsDTO.getRating_comment());
            reviewsRepository.save(reviews);
            
            return convertToDTO(reviews);
        }
        
        return null;
    }
    
    public void deleteReviews(int id_reviews){
        reviewsRepository.deleteById(id_reviews);
    }
    
    private ReviewsDTO convertToDTO(Reviews reviews){
        ReviewsDTO reviewsDTO = new ReviewsDTO();
        
        reviewsDTO.setId_reviews(reviews.getId_reviews());
        reviewsDTO.setRating_note(reviews.getRating_note());
        reviewsDTO.setRating_date(reviews.getRating_date());
        reviewsDTO.setRating_comment(reviews.getRating_comment());
        
        return reviewsDTO;
    }
}