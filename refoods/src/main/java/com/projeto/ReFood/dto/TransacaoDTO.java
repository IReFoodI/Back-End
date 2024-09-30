package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Cartao;
import com.projeto.ReFood.model.EnumStatusPedido;
import com.projeto.ReFood.model.Pedido;
import lombok.Data;
import java.util.Date;

@Data
public class TransacaoDTO {
    
    private int id_transacao;
    private Date data;
    private float valor;
    private EnumStatusPedido status;
    
    private Cartao fk_id_cartao;
    private Pedido fk_id_pedido;

}
