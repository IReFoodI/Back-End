package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="cartoes")
public class Cartao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cartao;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String validade;
    @Column(nullable = false)
    private String cvv;
    @Column(nullable = false)
    private String bandeira;
    
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario fk_id_usuario;

}
