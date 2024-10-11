package com.projeto.ReFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long orderId;

  @NotNull(message = "A data do pedido não pode ser nula.")
  @Column(nullable = false)
  private Date orderDate;

  @NotNull(message = "O status do pedido não pode ser nulo.")
  @Column(nullable = false)
  private EnumOrderStatus orderStatus;

  @NotNull(message = "O valor total não pode ser nulo.")
  @Column(nullable = false)
  private float totalValue;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "restaurant_id", nullable = false)
  private Restaurant restaurant;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private Set<OrderItem> orderOrderItems;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", nullable = false)
  private Address associatedAddress;

  @OneToOne(mappedBy = "associatedHistoricalOrder")
  private HistoricalOrder associatedHistoricalOrder;

  @OneToOne(mappedBy = "associatedOrder")
  private Transaction associatedTransaction;

}
