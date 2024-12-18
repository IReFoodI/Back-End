package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long orderId;

  @Column(nullable = false)
  private Date orderDate;

  @Column
  private Date deliveryDate;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EnumOrderStatus orderStatus;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, columnDefinition = "enum('RETIRADA', 'ENTREGA') default 'RETIRADA'")
  private EnumDeliveryType deliveryType;

  @Column(nullable = false)
  private float totalValue;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "restaurant_id", nullable = false)
  private Restaurant restaurant;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", nullable = false)
  private Address associatedAddress;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<OrderItem> orderItems;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "review_id", referencedColumnName = "review_id", nullable = true)
  private Review review;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id", nullable = true)
  private Transaction transaction;

}
