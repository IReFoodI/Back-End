package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Cartao;
import lombok.Data;

@Data
public class CartaoDTO {
    
    private int id_cartao;
    private String numero;
    private String validade;
    private String cvv;

//    private Usuario fk_id_usuario;

}
