package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Restaurante;
import com.projeto.ReFood.model.Usuario;
import lombok.Data;

@Data
public class EnderecoDTO {
    
    private int id_endereco;
    private String cep;
    private String estado;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private String tipo;
    private boolean is_padrao; //default = false
    
    private Usuario fk_id_usuario;
    private Restaurante fk_id_restaurante;

}
