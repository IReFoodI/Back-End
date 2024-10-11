package com.projeto.ReFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long userId;

  @NotBlank(message = "O nome é obrigatório.")
  @Column(nullable = false)
  private String name;

  @NotBlank(message = "O sobrenome é obrigatório.")
  @Column(nullable = false)
  private String surname;

  @NotBlank(message = "O CPF é obrigatório.")
  @Column(nullable = false, unique = true)
  private String cpf;

  @NotBlank(message = "O e-mail é obrigatório.")
  @Column(nullable = false, unique = true)
  private String email;

  @NotBlank(message = "A senha é obrigatória.")
  @Column(nullable = false)
  private String password;

  @NotBlank(message = "O telefone é obrigatório.")
  @Column(nullable = false)
  private String phone;

  @NotNull(message = "A data de criação é obrigatória.")
  @Column(name = "date_creation", nullable = false)
  private LocalDateTime dateCreation;

  @Column(name = "last_login")
  private LocalDateTime lastLogin;

  @OneToMany(mappedBy = "user")
  private Set<Address> userAddresses;

  @OneToMany(mappedBy = "user")
  private Set<Favorite> userFavorites;

  @OneToMany(mappedBy = "user")
  private Set<Card> userCards;

  @OneToMany(mappedBy = "user")
  private Set<Notification> userNotifications;

  @OneToMany(mappedBy = "user")
  private Set<Order> userOrders;

  @OneToMany(mappedBy = "user")
  private Set<Review> userReviews;

  @OneToMany(mappedBy = "user")
  private Set<HistoricalOrder> userHistoricalOrders;
}
