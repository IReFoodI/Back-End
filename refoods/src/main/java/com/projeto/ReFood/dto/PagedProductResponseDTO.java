package com.projeto.ReFood.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagedProductResponseDTO {
  private List<ProductRestaurantDTO> products;
  private int currentPage;
  private int totalPages;
  private long totalItems;
  private int itemsPerPage;

  public PagedProductResponseDTO(List<ProductRestaurantDTO> products, int currentPage, int totalPages, long totalItems,
      int itemsPerPage) {
    this.products = products;
    this.currentPage = currentPage;
    this.totalPages = totalPages;
    this.totalItems = totalItems;
    this.itemsPerPage = itemsPerPage;
  }
}
