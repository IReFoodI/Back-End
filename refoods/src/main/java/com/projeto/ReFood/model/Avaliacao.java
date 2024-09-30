package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="avaliacoes")
public class Avaliacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_avaliacoes;
    @Column(nullable = false)
    private int nota_avaliacao;
    @Column(nullable = false)
    private Date data_avaliacao;
    @Column
    private String comentario_avaliacao;
    
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario fk_id_usuarios;
    @JoinColumn(name = "fk_id_restaurantes", referencedColumnName = "fk_id_restaurantes")
    private Restaurante fk_id_restaurantes;

}
