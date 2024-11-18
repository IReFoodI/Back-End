package com.projeto.ReFood.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CartDetails {
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class CartDetailsDTO {
    private RestaurantDetailsDTO restaurant;
    private List<CartItemsDto> items;
  }
}
