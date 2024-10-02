package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="favorites")
public class Favorite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_favorite;
    @Column(nullable = false)
    private Date addition_date;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private User fkid_user_fav;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_restaurant", referencedColumnName = "id_restaurant")
    private Restaurant fkid_restaurantFav;
}
