package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name="orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;
    @Column(nullable = false)
    private Date order_date;
    @Column(nullable = false)
    private EnumOrderStatus order_status;
    @Column(nullable = false)
    private float total_value;
    
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user")
    // private User fkid_userOrder;
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_id_restaurant", referencedColumnName = "id_restaurant")
    // private Restaurant fkid_restaurantOrder;
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_id_address", referencedColumnName = "id_address")
    // private Address fkid_addressOrder;
    
    // @OneToOne(mappedBy = "fkid_orderItemsOrders")
    // private ItemsOrders orderItemsOrders;
    // @OneToOne(mappedBy = "fkid_orderHistoricalOrders")
    // private HistoricalOrders historicalOrdersOrders;
    // @OneToOne(mappedBy = "fkid_orderTransaction")
    // private Transaction orderTransaction;

}
