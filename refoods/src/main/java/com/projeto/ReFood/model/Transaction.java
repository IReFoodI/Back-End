package com.projeto.ReFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "tb_transactions")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "transaction_id")
  private Long transactionId;

  @NotNull(message = "A data da transação é obrigatória.")
  @Column(nullable = false)
  private Date transactionDate;

  @NotNull(message = "O valor da transação é obrigatório.")
  @Column(nullable = false)
  private float transactionValue;

  @NotNull(message = "O status da transação é obrigatório.")
  @Enumerated(EnumType.STRING) // Assume que EnumTransactionStatus é uma enum.
  @Column(nullable = false)
  private EnumTransactionStatus transactionStatus;

  @ManyToOne(optional = false)
  @JoinColumn(name = "card_id", nullable = false)
  private Card card;

  @OneToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "order_id", nullable = false)
  private Order associatedOrder;

}
