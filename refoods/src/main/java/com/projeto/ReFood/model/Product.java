package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_product;
  @Column(nullable = false)
  private String name_prod;
  @Column
  private String description_prod;
  @Column
  private String url_img_prod;
  @Column(nullable = false)
  private float value_prod;
  @Column(nullable = false)
  private int discount; // % check: descontoPerc >= 0 and descontoPerc <= 100
  @Column(nullable = false)
  private Date addition_date;
  @Column(nullable = false)
  private boolean active;

  @ManyToOne
  @JoinColumn(name = "id_restaurant", nullable = false)
  private Restaurant fkid_restaurant_prod;

  @OneToMany(mappedBy = "fkid_product_itemsOrders", cascade = CascadeType.ALL)
  private Set<ItemsOrders> itemsOrders;

}
