package com.projeto.ReFood.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "tb_cart")
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cart_id")
  private Long cartId;

  @NotNull(message = "O valor total não pode ser nulo.")
  @Min(value = 0, message = "O valor total deve ser maior ou igual a zero.")
  @Column(nullable = false)
  private float totalValue;

  @NotNull(message = "O usuário associado não pode ser nulo.")
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @JsonIgnore
  private User user;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude
  @JsonIgnore
  private Set<CartItem> cartItems;

}
