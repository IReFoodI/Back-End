package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="cards")
public class Card {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_card;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String validity;
    @Column(nullable = false)
    private String cvv;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private User fkid_user_card;
    
    @OneToMany(mappedBy = "fkid_card_transaction")
    private Set<Transaction> cardTransaction;

}
