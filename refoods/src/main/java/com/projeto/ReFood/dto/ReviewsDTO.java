package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;
import lombok.Data;
import java.util.Date;

@Data
public class ReviewsDTO {

  private int id_reviews;
  private int rating_note;
  private Date rating_date;
  private String rating_comment;

  private User fkid_userReview;
  private Restaurant fkid_restaurantReview;

}
