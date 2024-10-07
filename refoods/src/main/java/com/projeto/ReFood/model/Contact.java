package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="contacts")
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contact;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String phone;
    
    // @ManyToOne
    // @JoinColumn(name = "fk_id_restaurant", nullable = false)
    // private Restaurant fkid_restaurant_contact;

}
