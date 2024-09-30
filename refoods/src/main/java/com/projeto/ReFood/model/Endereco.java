package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="enderecos")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_endereco;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String numero;
    @Column
    private String complemento;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private boolean is_padrao; //default = false
    
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario fk_id_usuario;
    @JoinColumn(name = "fk_id_restaurante", referencedColumnName = "id_restaurante")
    private Restaurante fk_id_restaurante;

}
