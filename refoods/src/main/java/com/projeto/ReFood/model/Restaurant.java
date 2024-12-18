package com.projeto.ReFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_restaurants")
public class Restaurant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "restaurant_id")
  private Long restaurantId;

  @NotBlank(message = "CNPJ não pode estar vazio.")
  @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter exatamente 14 dígitos.")
  @Column(nullable = false, unique = true, length = 14)
  private String cnpj;

  @NotBlank(message = "Nome fantasia não pode estar vazio.")
  @Size(min = 3, max = 100, message = "Nome fantasia deve ter entre 3 e 100 caracteres.")
  @Column(nullable = false, length = 100)
  private String fantasy;

  @NotBlank(message = "Email não pode estar vazio.")
  @Email(message = "Email deve ser válido.")
  @Size(max = 100, message = "Email deve ter no máximo 100 caracteres.")
  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @NotBlank(message = "Senha não pode estar vazia.")
  @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres.")
  @Column(nullable = false)
  private String password;

  @Column(nullable = false, updatable = false)
  private LocalDateTime dateCreation = LocalDateTime.now();

  @Column
  private LocalDateTime lastLogin;

  @Enumerated(EnumType.STRING)
  private EnumRestaurantCategory category;

  @Pattern(regexp = "^(http|https)://.*$", message = "A URL do banner deve ser válida.")
  @Column
  private String urlBanner;

  @Pattern(regexp = "^(http|https)://.*$", message = "A URL do logo deve ser válida.")
  @Column
  private String urlLogo;

  @Min(value = 0, message = "A quantidade de avaliações deve ser no mínimo 0.")
  @Column(nullable = false)
  private int quantityEvaluations = 0;

  @Min(value = 0, message = "O total de avaliações deve ser no mínimo 0.")
  @Column(nullable = false)
  private int totalEvaluations = 0;

  @NotBlank(message = "Telefone não pode estar vazio.")
  @Pattern(regexp = "\\d{10,15}", message = "O telefone deve conter entre 10 e 15 dígitos.")
  @Column(nullable = false, length = 15)
  private String phone;

  @Size(min = 20, message = "A descrição deve ter no mínimo 20 caracteres")
  String description;

  @Min(value = 0, message = "A avaliação média deve ser no mínimo 0.")
  @Max(value = 5, message = "A avaliação média deve ser no máximo 5.")
  @Column(nullable = false)
  private float averageRating = 0.0f;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Contact> restaurantContacts;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Address> restaurantAddresses;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Product> restaurantProducts;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Review> restaurantReviews;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Favorite> restaurantFavorites;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Order> restaurantOrders;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<HistoricalOrder> restaurantHistoricalOrders;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Notification> restaurantNotifications;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<RestaurantHours> restaurantHours;

  @Override
  public String toString() {
    return "Restaurant{" +
        "restaurantId=" + restaurantId +
        ", cnpj='" + cnpj + '\'' +
        ", fantasy='" + fantasy + '\'' +
        ", email='" + email + '\'' +
        ", password='" + "[PROTECTED]" + '\'' + // para proteger o campo de senha
        ", dateCreation=" + dateCreation +
        ", lastLogin=" + lastLogin +
        ", category=" + category +
        ", urlBanner='" + urlBanner + '\'' +
        ", urlLogo='" + urlLogo + '\'' +
        ", quantityEvaluations=" + quantityEvaluations +
        ", totalEvaluations=" + totalEvaluations +
        ", phone='" + phone + '\'' +
        ", description='" + description + '\'' +
        ", averageRating=" + averageRating +
        '}';
  }

}
