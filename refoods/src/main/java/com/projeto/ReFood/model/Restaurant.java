package com.projeto.ReFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @Column(nullable = false)
    private String cnpj;

    @NotBlank(message = "Nome fantasia não pode estar vazio.")
    @Column(nullable = false)
    private String fantasy;

    @NotBlank(message = "Email não pode estar vazio.")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Senha não pode estar vazia.")
    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateCreation = LocalDateTime.now();

    @Column
    private LocalDateTime lastLogin;

    @Column
    private String urlBanner;

    @Column
    private String urlLogo;

    @Column
    private int quantityEvaluations = 0; // default 0

    @Column
    private int totalEvaluations = 0; // default 0

    @Column
    private float averageRating = 0.0f; // default 0

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

}
