package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transaction;
    @Column(nullable = false)
    private Date transaction_date;
    @Column(nullable = false)
    private float transaction_value;
    @Column(nullable = false)
    private EnumTransactionStatus transaction_status;
    
    // @ManyToOne
    // @JoinColumn(name = "fk_id_card")
    // private Card fkid_card_transaction;
    
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_id_order", referencedColumnName = "id_order")
    // private Order fkid_orderTransaction;

}
