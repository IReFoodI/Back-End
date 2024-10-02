package com.projeto.ReFood.dto;

import lombok.Data;
import java.util.Date;

@Data
public class RestaurantDTO {
    
    private int id_restaurante;
    private String cnpj;
    private String nome_fantasia;
    private String email;
    private String senha;
    private Date data_cricao;
    private String url_banner;
    private String url_logo;
    private int quantidade_avaliacoes; //default 0
    private int total_avaliacoes; //default 0
    private float media_avaliacao; //default 0

}
