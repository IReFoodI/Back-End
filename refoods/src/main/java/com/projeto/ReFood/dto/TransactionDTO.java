package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Cartao;
import com.projeto.ReFood.model.EnumOrderStatus;
import com.projeto.ReFood.model.Pedido;
import lombok.Data;
import java.util.Date;

@Data
public class TransactionDTO {
    
    private int id_transacao;
    private Date data;
    private float valor;
    private EnumOrderStatus status;
    
    private Cartao fk_id_cartao;
    private Pedido fk_id_pedido;

}
