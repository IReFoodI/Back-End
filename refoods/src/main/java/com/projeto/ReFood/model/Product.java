package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "tb_products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long productId;

  @Column(name = "name_product", nullable = false)
  private String nameProduct;

  @Column(name = "description_product")
  private String descriptionProduct;

  @Column(name = "url_img_product")
  private String urlImgProduct;

  @Column(name = "original_price", nullable = false)
  private float originalPrice;

  @Column(name = "sell_price", nullable = false)
  private float sellPrice;

  @Column(name = "expiration_date", nullable = false)
  private Date expirationDate;

  @Column(name = "quantity", nullable = false)
  private int quantity;

  @Enumerated(EnumType.STRING)
  @Column(name = "category", nullable = false)
  private EnumProductCategory categoryProduct;

  @Column(name = "addition_date", nullable = false)
  private Date additionDate;

  @Column(name = "active", nullable = false)
  private boolean active;

  @ManyToOne
  @JoinColumn(name = "restaurant_id", nullable = false)
  private Restaurant restaurant;
}
