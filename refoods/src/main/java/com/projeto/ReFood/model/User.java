package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private LocalDateTime  date_creation;
    private LocalDateTime  last_login;

    @OneToMany(mappedBy = "fkid_user_address")
    private Set<Address> userAdress;

    @OneToMany(mappedBy = "fkid_user_fav")
    private Set<Favorite> userFav;

    @OneToMany(mappedBy = "fkid_user_card")
    private Set<Card> usersCard;
    
    @OneToOne(mappedBy = "fkid_userReview")
    private Review userReview;

    @OneToOne(mappedBy = "fkid_userOrder")
    private Order userOrder;
    
    @OneToOne(mappedBy = "fkid_userHistoricalOrders")
    private HistoricalOrders userOrdersOrders;

    @OneToMany(mappedBy = "fk_id_user")
    private Set<UserNotification> usersNotifications;
    
}
