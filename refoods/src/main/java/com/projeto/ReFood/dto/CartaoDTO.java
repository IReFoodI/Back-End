package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.EnumTipoCartao;
import com.projeto.ReFood.model.Usuario;
import lombok.Data;

@Data
public class CartaoDTO {
    
    private int id_cartao;
    private String numero;
    private EnumTipoCartao tipo; //('Crédito', 'Débito')
    private String bandeira;

//    private Usuario fk_id_usuario;

}
