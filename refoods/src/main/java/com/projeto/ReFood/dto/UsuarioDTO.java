package com.projeto.ReFood.dto;

import lombok.Data;
import java.util.Date;

@Data
public class UsuarioDTO {
    
    private int id_usuario;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String telefone;
//    private String senha;
//    private Date data_criacao;
//    private Date ultimo_login;

}
