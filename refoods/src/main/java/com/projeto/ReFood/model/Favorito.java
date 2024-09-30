package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="favoritos")
public class Favorito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_favoritos;
    @Column(nullable = false)
    private Date data_adicao;
    
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario fk_id_usuarios;
    @JoinColumn(name = "fk_id_restaurantes", referencedColumnName = "id_restaurantes")
    private Restaurante fk_id_restaurantes;

}
