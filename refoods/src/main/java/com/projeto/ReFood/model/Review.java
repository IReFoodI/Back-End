package com.projeto.ReFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "tb_reviews")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "review_id")
  private Long reviewId;

  @NotNull(message = "Nota de avaliação não pode ser nula.")
  @Column(nullable = false)
  private int ratingNote;

  @NotNull(message = "Data de avaliação não pode ser nula.")
  @Column(nullable = false)
  private Date ratingDate;

  @Column
  private String ratingComment;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(optional = false)
  @JoinColumn(name = "restaurant_id", nullable = false)
  private Restaurant restaurant;

}
