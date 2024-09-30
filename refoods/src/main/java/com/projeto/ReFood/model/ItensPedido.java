package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="itensPedido")
public class ItensPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_itens_pedido;
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false)
    private float valor_unidade;
    @Column(nullable = false)
    private float subtotal;
    
    @JoinColumn(name = "fk_id_pedidos", referencedColumnName = "id_pedidos")
    private Pedido fk_id_pedidos;
    @JoinColumn(name = "fk_id_produtos", referencedColumnName = "id_produtos")
    private Produto fk_id_produtos;

}
