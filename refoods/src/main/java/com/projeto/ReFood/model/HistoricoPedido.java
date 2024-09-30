package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="historicopedidos")
public class HistoricoPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_historico;
    @Column(nullable = false)
    private EnumStatusPedido status_ant;
    @Column(nullable = false)
    private Date data_mod;
    
    @JoinColumn(name = "fk_id_pedido", referencedColumnName = "id_pedido")
    private Pedido fk_id_pedido;
    @JoinColumn(name = "fk_id_restaurante", referencedColumnName = "id_restaurante")
    private Restaurante fk_id_restaurante;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario fk_id_usuario;

}
