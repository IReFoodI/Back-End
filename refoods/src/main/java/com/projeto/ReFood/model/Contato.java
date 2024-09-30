package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="contatos")
public class Contato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contatos;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String numero;
    
    @JoinColumn(name = "fk_id_restaurante", referencedColumnName = "id_restaurante")
    private Restaurante fk_id_restaurante;

}
