package com.projeto.ReFood.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "tb_cart_items")
public class CartItem {

  @EmbeddedId
  private CartItemPK cartItemId;

  @NotNull(message = "A quantidade não pode ser nula.")
  @Min(value = 1, message = "A quantidade deve ser pelo menos 1.")
  @Column(name = "quantity", nullable = false)
  private int quantity;

  @NotNull(message = "O valor unitário não pode ser nulo.")
  @Column(nullable = false)
  private float unitValue;

  @NotNull(message = "O subtotal não pode ser nulo.")
  @Column(name = "subtotal", nullable = false)
  private float subtotal;

  @NotNull(message = "O carrinho não pode ser nulo.")
  @ManyToOne
  @MapsId("cartId")
  @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Cart cart;

  @NotNull(message = "O produto não pode ser nulo.")
  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "restaurant_id", nullable = true)
  private Restaurant restaurant;

  @Column(name = "addedAt", nullable = false)
  private LocalDateTime addedAt = LocalDateTime.now();

  public CartItem() {
  }

  public CartItem(Cart cart, Product product, int quantity, Restaurant restaurant) {
    this.cart = cart;
    this.product = product;
    this.quantity = quantity;
    this.restaurant = restaurant;
  }

}
