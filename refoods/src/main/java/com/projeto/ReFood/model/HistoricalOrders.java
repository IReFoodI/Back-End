package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="historicalOrders")
public class HistoricalOrders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_history;
    @Column(nullable = false)
    private EnumOrderStatus order_status;
    @Column(nullable = false)
    private Date date_mod;
    
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_id_order", referencedColumnName = "id_order")
    // private Order fkid_orderHistoricalOrders;
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_id_restaurant", referencedColumnName = "id_restaurant")
    // private Restaurant fkid_restaurantHistoricalOrders;
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user")
    // private User fkid_userHistoricalOrders;

}
