package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Restaurante;
import lombok.Data;

@Data
public class ContactDTO {
    
    private int id_contatos;
    private String descricao;
    private String numero;
    
    private Restaurante fk_id_restaurante;

}
