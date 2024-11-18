package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.EnumRestaurantCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDetailsDTO {
  private Long restaurantId;
  private String fantasy;
  private EnumRestaurantCategory category;
  private String urlBanner;
  private String urlLogo;
  private int quantityEvaluations = 0;
  private int totalEvaluations = 0;
  private String phone;
  private String description;
  private float averageRating = 0.0f;
  private HourDTO timesOfTheDay;
  private AddressDetailsDTO address;
}
