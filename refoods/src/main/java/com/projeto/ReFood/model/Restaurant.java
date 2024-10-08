package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="restaurants")
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_restaurant;
    @Column(nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String fantasy;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;
    @Column
    private String url_banner;
    @Column
    private String url_logo;
    @Column
    private int quantity_evaluations; //default 0
    @Column
    private int total_evaluations; //default 0
    @Column
    private float average_rating; //default 0
    
    @OneToMany(mappedBy = "fkid_restaurant_contact")
    private List<Contact> restaurantContact;

    @OneToMany(mappedBy = "fkid_restaurant_address")
    private Set<Address> restaurantAdress;

    @OneToMany(mappedBy = "fkid_restaurant_prod")
    private Set<Product> restaurantProd;
    
    @OneToOne(mappedBy = "fkid_restaurantReview")
    private Reviews restaurantReview;

    @OneToOne(mappedBy = "fkid_restaurantFav")
    private Favorite restaurantFav;

    @OneToOne(mappedBy = "fkid_restaurantOrder")
    private Order restaurantOrder;
    
    @OneToOne(mappedBy = "fkid_restaurantHistoricalOrders")
    private HistoricalOrders historicalOrdersReview;
}
