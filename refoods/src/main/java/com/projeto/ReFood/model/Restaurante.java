package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="restaurantes")
public class Restaurante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_restaurante;
    @Column(nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String nome_fantasia;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private Date data_cricao;
    @Column
    private String url_banner;
    @Column
    private String url_logo;
    @Column
    private int quantidade_avaliacoes; //default 0
    @Column
    private int total_avaliacoes; //default 0
    @Column
    private float media_avaliacao; //default 0

}
