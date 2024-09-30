package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Endereco;
import com.projeto.ReFood.model.EnumStatusPedido;
import com.projeto.ReFood.model.Restaurante;
import com.projeto.ReFood.model.Usuario;
import lombok.Data;
import java.util.Date;

@Data
public class PedidoDTO {
    
    private int id_pedido;
    private Date data_pedido;
    private EnumStatusPedido status_pedido;
    private float preco_total;
    
    private Usuario fk_id_usuario;
    private Restaurante fk_id_restaurante;
    private Endereco fk_id_endereco_entrega;
}
