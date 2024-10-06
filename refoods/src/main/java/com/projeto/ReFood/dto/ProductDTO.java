package com.projeto.ReFood.dto;

import lombok.Data;
import java.util.Date;

import com.projeto.ReFood.model.Restaurant;

@Data
public class ProductDTO {

  private int id_product;
  private String name_prod;
  private String description_prod;
  private String url_img_prod;
  private float value_prod;
  private int discount; // % check: descontoPerc >= 0 and descontoPerc <= 100
  private Date addition_date;
  private boolean active;

  private Restaurant fkid_restaurant_prod;

}
