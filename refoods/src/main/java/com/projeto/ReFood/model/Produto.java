package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produto;
    @Column(nullable = false)
    private String nome_prod;
    @Column
    private String descricao_prod;
    @Column
    private String url_img_prod;
    @Column(nullable = false)
    private float preco_prod;
    @Column(nullable = false)
    private int desc_perc; //% check: descontoPerc >= 0 and descontoPerc <= 100
    @Column(nullable = false)
    private Date data_adicao;
    @Column(nullable = false)
    private boolean ativo;
    
    @JoinColumn(name = "fk_id_restaurante", referencedColumnName = "id_restaurante")
    private Restaurante fk_id_restaurante;

}
