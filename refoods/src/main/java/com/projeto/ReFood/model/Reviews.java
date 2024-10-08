package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="reviews")
public class Reviews {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reviews;
    @Column(nullable = false)
    private int rating_note;
    @Column(nullable = false)
    private Date rating_date;
    @Column
    private String rating_comment;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user")
    private User fkid_userReview;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_restaurant", referencedColumnName = "id_restaurant")
    private Restaurant fkid_restaurantReview;

}
