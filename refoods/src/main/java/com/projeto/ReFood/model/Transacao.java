package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transacao;
    @Column(nullable = false)
    private Date data;
    @Column(nullable = false)
    private float valor;
    @Column(nullable = false)
    private EnumStatusPedido status;
    
    @JoinColumn(name = "fk_id_cartao", referencedColumnName = "id_cartao")
    private Cartao fk_id_cartao;
    @JoinColumn(name = "fk_id_pedido", referencedColumnName = "id_pedido")
    private Pedido fk_id_pedido;

}
