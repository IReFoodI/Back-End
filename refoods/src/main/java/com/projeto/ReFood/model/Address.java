package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="addresses")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_address;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String number;
    @Column
    private String complement;
    @Column(nullable = false)
    private String address_type;
    @Column(nullable = false)
    private boolean standard; //default = false
    
    // @ManyToOne
    // @JoinColumn(name = "fk_id_user")
    // private User fkid_user_address;
    
    // @ManyToOne
    // @JoinColumn(name = "fk_id_restaurant")
    // private Restaurant fkid_restaurant_address;
    
    // @OneToOne(mappedBy = "fkid_addressOrder")
    // private Order addressOrder;

}
