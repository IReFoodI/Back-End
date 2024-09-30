package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Pedido;
import com.projeto.ReFood.model.Produto;
import lombok.Data;

@Data
public class ItensPedidoDTO {
    
    private int id_itens_pedido;
    private int quantidade;
    private float valor_unidade;
    private float subtotal;
    
    private Pedido fk_id_pedidos;
    private Produto fk_id_produtos;

}
