package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="itemsOrders")
public class ItemsOrders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_items_orders;
    @Column(nullable = false)
    private int amount;
    @Column(nullable = false)
    private float unit_value;
    @Column(nullable = false)
    private float subtotal;
    
    @OneToOne
    @JoinColumn(name = "fk_id_order", referencedColumnName = "id_order")
    private Order fkid_orderItemsOrders;
    
    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product fkid_product_itemsOders;

}
