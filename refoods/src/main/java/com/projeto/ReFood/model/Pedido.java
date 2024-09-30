package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name="pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;
    @Column(nullable = false)
    private Date data_pedido;
    @Column(nullable = false)
    private EnumStatusPedido status_pedido;
    @Column(nullable = false)
    private float preco_total;
    
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario fk_id_usuario;
    @JoinColumn(name = "fk_id_restaurante", referencedColumnName = "id_restaurante")
    private Restaurante fk_id_restaurante;
    @JoinColumn(name = "fk_id_endereco_entrega", referencedColumnName = "id_endereco")
    private Endereco fk_id_endereco_entrega;

}
