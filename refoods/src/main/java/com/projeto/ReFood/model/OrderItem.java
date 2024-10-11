package com.projeto.ReFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_order_items")
public class OrderItem {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId;

    @NotNull(message = "A quantidade não pode ser nula.")
    @Column(nullable = false)
    private int amount;

    @NotNull(message = "O valor unitário não pode ser nulo.")
    @Column(nullable = false)
    private float unitValue;

    @NotNull(message = "O subtotal não pode ser nulo.")
    @Column(nullable = false)
    private float subtotal;

    @NotNull(message = "O pedido não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @NotNull(message = "O produto não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
