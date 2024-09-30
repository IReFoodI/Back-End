package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.EnumStatusPedido;
import com.projeto.ReFood.model.Pedido;
import com.projeto.ReFood.model.Restaurante;
import com.projeto.ReFood.model.Usuario;
import lombok.Data;
import java.util.Date;

@Data
public class HistoricoPedidoDTO {
    
    private int id_historico;
    private EnumStatusPedido status_ant;
    private Date data_mod;
    
    private Pedido fk_id_pedido;
    private Restaurante fk_id_restaurante;
    private Usuario fk_id_usuario;

}
